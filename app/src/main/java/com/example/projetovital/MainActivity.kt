package com.example.projetovital

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.projetovital.data.db.AppDatabase
import com.example.projetovital.data.db.entity.AgendaEntity
import com.example.projetovital.databinding.ActivityMainBinding
import com.example.projetovital.ui.projetovital.agenda.AgendaFragment
import com.example.projetovital.ui.projetovital.agenda.DailyNotificationWorker
import com.example.projetovital.ui.projetovital.cadastro.CadastroFragment
import com.example.projetovital.ui.projetovital.cadastro.FormCadastroFragment
import com.example.projetovital.ui.projetovital.exames.ExamesFragment
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Vincula o layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar a Toolbar como a ActionBar
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)

        // Verifica se o intent tem o sinalizador para abrir o FormCadastro
        if (intent.getBooleanExtra("openFormCadastro", false)) {
            replaceFragment(FormCadastroFragment()) // Abre o FormCadastro diretamente
        } else {
            // Chama a função para mostrar a tela inicial (ex.: ExamesFragment)
            replaceFragment(ExamesFragment())
        }

        // Define a exibição do fragment inicial e a navegação entre os fragments
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_exame -> replaceFragment(ExamesFragment())
                R.id.menu_agendamento -> replaceFragment(AgendaFragment())
                R.id.menu_cadastro -> replaceFragment(CadastroFragment())
                else -> {
                    replaceFragment(ExamesFragment())
                }
            }
            true
        }

        // Mostrar notificação 10 segundos após o login
        showNotificationAfterLogin()

        // Agendar notificações diárias para 08h e 20h
        scheduleDailyNotifications()
    }

    // Função para trocar de fragment
    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    // Notificação 10 segundos após o login com agendamentos do dia seguinte
    private fun showNotificationAfterLogin() {
        // Atrasar a notificação por 10 segundos após o login
        Handler(Looper.getMainLooper()).postDelayed({
            // Obter a data de amanhã
            val tomorrow = Calendar.getInstance().apply {
                add(Calendar.DAY_OF_MONTH, 1)
                set(Calendar.HOUR_OF_DAY, 0)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
            }.time

            // Log para depuração
            Log.d("MainActivity", "Consultando agendamentos para: $tomorrow")

            // Usando Coroutine para evitar acessar o banco de dados na UI thread
            GlobalScope.launch(Dispatchers.IO) {
                // Obter os agendamentos para amanhã
                val db = AppDatabase.getInstance(applicationContext)
                val agendaDao = db.agendaDao()
                val consultasAmanha = agendaDao.getAgendasForDate(tomorrow)

                // Log para verificar os dados recuperados
                Log.d("MainActivity", "Consultas agendadas para amanhã: ${consultasAmanha.size}")

                // Voltar para a thread principal para atualizar a UI
                withContext(Dispatchers.Main) {
                    if (consultasAmanha.isNotEmpty()) {
                        sendConsultasNotification(consultasAmanha)
                    } else {
                        Log.d("MainActivity", "Nenhuma consulta agendada para amanhã.")
                    }
                }
            }
        }, 10000) // 10 segundos após o login
    }

    // Enviar notificação com agendamentos para o dia seguinte
    private fun sendConsultasNotification(consultas: List<AgendaEntity>) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Criar o canal de notificações (necessário no Android 8+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "LOGIN_NOTIFICATION",
                "Notificação após login",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "Consultas agendadas para o dia seguinte"
            notificationManager.createNotificationChannel(channel)
        }

        // Criar a mensagem da notificação
        val message = consultas.joinToString("\n") { consulta ->
            "${consulta.especialidadeAgenda} - ${consulta.horaAgenda} no ${consulta.localAgenda}"
        }

        Log.d("MainActivity", "Enviando notificação: $message")

        // Criar a notificação
        val notification = NotificationCompat.Builder(this, "LOGIN_NOTIFICATION")
            .setSmallIcon(R.drawable.logo_vital2) // Substitua pelo ícone correto
            .setContentTitle("Consultas de Amanhã")
            .setContentText("Você tem ${consultas.size} consulta(s) agendada(s) amanhã.")
            .setStyle(NotificationCompat.BigTextStyle().bigText(message))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        notificationManager.notify(2, notification)
        Log.d("MainActivity", "Notificação enviada!")
    }

    // Agendar notificações diárias para 08h e 20h
    private fun scheduleDailyNotifications() {
        val workRequestMorning =
            PeriodicWorkRequestBuilder<DailyNotificationWorker>(1, TimeUnit.DAYS)
                .setInitialDelay(calculateInitialDelay(8), TimeUnit.MILLISECONDS)
                .build()

        val workRequestEvening =
            PeriodicWorkRequestBuilder<DailyNotificationWorker>(1, TimeUnit.DAYS)
                .setInitialDelay(calculateInitialDelay(20), TimeUnit.MILLISECONDS)
                .build()

        // Usando ExistingPeriodicWorkPolicy.UPDATE ao invés de REPLACE
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "DailyNotificationMorningWork",
            ExistingPeriodicWorkPolicy.UPDATE,
            workRequestMorning
        )

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "DailyNotificationEveningWork",
            ExistingPeriodicWorkPolicy.UPDATE,
            workRequestEvening
        )
    }


    private fun calculateInitialDelay(hour: Int): Long {
        val now = Calendar.getInstance()
        val target = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
        }

        if (now.after(target)) {
            target.add(Calendar.DAY_OF_MONTH, 1) // Agendar para o próximo dia
        }

        return target.timeInMillis - now.timeInMillis
    }
}
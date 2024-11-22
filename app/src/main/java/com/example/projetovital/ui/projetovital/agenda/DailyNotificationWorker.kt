package com.example.projetovital.ui.projetovital.agenda

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.projetovital.R
import com.example.projetovital.data.db.AppDatabase
import com.example.projetovital.data.db.entity.AgendaEntity
import java.util.Calendar

class DailyNotificationWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        // Obter a data de amanhã
        val tomorrow = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_MONTH, 1)
        }.time

        // Obter os agendamentos para amanhã
        val db = AppDatabase.getInstance(applicationContext)
        val agendaDao = db.agendaDao()
        val consultasAmanha = agendaDao.getAgendasForDate(tomorrow)

        if (consultasAmanha.isNotEmpty()) {
            sendConsultasNotification(consultasAmanha)
        }

        // Quando não houver consultas, simplesmente não faz nada e retorna sucesso
        return Result.success()
    }

    private fun sendConsultasNotification(consultas: List<AgendaEntity>) {
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Criar o canal de notificações (necessário no Android 8+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "DAILY_NOTIFICATION",
                "Notificação Diária",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "Consultas agendadas para o dia seguinte"
            notificationManager.createNotificationChannel(channel)
        }

        // Criar a mensagem da notificação
        val message = consultas.joinToString("\n") { consulta ->
            "${consulta.especialidadeAgenda} - ${consulta.horaAgenda} no ${consulta.localAgenda}"
        }

        val notification = NotificationCompat.Builder(applicationContext, "DAILY_NOTIFICATION")
            .setSmallIcon(R.drawable.logo_vital2) // Substitua pelo ícone correto
            .setContentTitle("Consultas de amanhã")
            .setContentText("Você tem ${consultas.size} consulta(s) agendada(s) amanhã.")
            .setStyle(NotificationCompat.BigTextStyle().bigText(message))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        notificationManager.notify(1, notification)
    }
}



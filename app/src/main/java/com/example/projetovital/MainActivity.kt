package com.example.projetovital

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.projetovital.databinding.ActivityMainBinding
import com.example.projetovital.ui.projetovital.agenda.AgendaFragment
import com.example.projetovital.ui.projetovital.cadastro.CadastroFragment
import com.example.projetovital.ui.projetovital.exames.ExamesFragment
import com.google.android.material.appbar.MaterialToolbar

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

        //Chama a função para trocar de fragment(Tela)
        replaceFragment(ExamesFragment())

        //Define a exibição do fragment inicial e a navegação entre os fragments
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
    }
    //Teste Git 2

    //função para trocar de fragment
    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
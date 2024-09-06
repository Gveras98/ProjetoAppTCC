package com.example.projetovital

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projetovital.databinding.FragmentAgendaBinding

class AgendaFragment : Fragment() {

    private lateinit var binding: FragmentAgendaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate o layout usando ViewBinding
        binding = FragmentAgendaBinding.inflate(inflater, container, false)

        // Define o botão para chamar a função replaceFragment
        binding.btnCadAgendamento.setOnClickListener {
            // Chama a função replaceFragment da MainActivity
            (activity as? MainActivity)?.replaceFragment(FormAgendaFragment())
        }

        // Adicionar as Funções para Medicamentos e Alergias

        // Retorna a view raiz do binding
        return binding.root
    }
}
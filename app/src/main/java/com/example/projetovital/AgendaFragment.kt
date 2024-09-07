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


        // Adicionar as Funções para Medicamentos e Alergias

        // Retorna a view raiz do binding
        return binding.root
    }
}
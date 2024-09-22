package com.example.projetovital.ui.projetovital.agenda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projetovital.databinding.FragmentFormAgendaBinding


class FormAgendaFragment : Fragment() {
    private lateinit var binding: FragmentFormAgendaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Cria o layout usando ViewBinding
        binding = FragmentFormAgendaBinding.inflate(inflater, container, false)


        // Retorna a view raiz do binding
        return binding.root
    }
}
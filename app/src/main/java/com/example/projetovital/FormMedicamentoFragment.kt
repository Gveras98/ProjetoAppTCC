package com.example.projetovital

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projetovital.databinding.FragmentFormMedicamentoBinding

class FormMedicamentoFragment : Fragment() {

    private lateinit var binding: FragmentFormMedicamentoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Cria o layout usando ViewBinding
        binding = FragmentFormMedicamentoBinding.inflate(inflater, container, false)


        // Retorna a view raiz do binding
        return binding.root
    }
}
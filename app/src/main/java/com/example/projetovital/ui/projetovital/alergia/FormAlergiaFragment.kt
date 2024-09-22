package com.example.projetovital.ui.projetovital.alergia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projetovital.databinding.FragmentFormAlergiaBinding

class FormAlergiaFragment : Fragment() {

    private lateinit var binding: FragmentFormAlergiaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Cria o layout usando ViewBinding
        binding = FragmentFormAlergiaBinding.inflate(inflater, container, false)


        // Retorna a view raiz do binding
        return binding.root
    }
}
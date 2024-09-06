package com.example.projetovital

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projetovital.databinding.FragmentFormCadastroBinding

class FormCadastroFragment : Fragment() {

    private lateinit var binding: FragmentFormCadastroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Cria o layout usando ViewBinding
        binding = FragmentFormCadastroBinding.inflate(inflater, container, false)


        // Retorna a view raiz do binding
        return binding.root
    }
}
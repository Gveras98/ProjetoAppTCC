package com.example.projetovital

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projetovital.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() {

    private lateinit var binding: FragmentCadastroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate o layout usando ViewBinding
        binding = FragmentCadastroBinding.inflate(inflater, container, false)

        // Define o botão para chamar a função replaceFragment
        binding.btnAtualizarCadastro.setOnClickListener {
            // Chama a função replaceFragment da MainActivity
            (activity as? MainActivity)?.replaceFragment(FormCadastroFragment())
        }

        // Retorna a view raiz do binding
        return binding.root
    }
}
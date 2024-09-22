package com.example.projetovital

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projetovital.databinding.FragmentAlergiaBinding

class AlergiaFragment : Fragment() {

    private lateinit var binding: FragmentAlergiaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate o layout usando ViewBinding
        binding = FragmentAlergiaBinding.inflate(inflater, container, false)

        binding.btnNovoAlergia.setOnClickListener {
            // Navegue para o fragmento de formulário de alergia
            (activity as? MainActivity)?.replaceFragment(FormAlergiaFragment())
        }

        // Retorna a view raiz do binding
        return binding.root
    }
}
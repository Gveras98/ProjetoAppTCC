package com.example.projetovital

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projetovital.databinding.FragmentMedicamentoBinding

class MedicamentoFragment : Fragment() {

    private lateinit var binding: FragmentMedicamentoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate o layout usando ViewBinding
        binding = FragmentMedicamentoBinding.inflate(inflater, container, false)

        binding.btnNovoMedicamento.setOnClickListener {
            // Navegue para o fragmento de formulário de medicamento
            (activity as? MainActivity)?.replaceFragment(FormMedicamentoFragment())
        }

        // Retorna a view raiz do binding
        return binding.root
    }
}
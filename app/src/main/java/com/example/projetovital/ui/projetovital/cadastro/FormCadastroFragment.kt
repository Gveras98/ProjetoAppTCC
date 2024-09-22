package com.example.projetovital

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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


        // Define a configuração do ARRAY de Tipo Sanguíneo
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.tipos_sanguineos,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        // Aplica o adapter ao Spinner
        binding.spinnerTipoSanguineo.adapter = adapter
        //Fim

        //Atribuir mascaras para o Formulario



        // Retorna a view raiz do binding
        return binding.root
    }
}
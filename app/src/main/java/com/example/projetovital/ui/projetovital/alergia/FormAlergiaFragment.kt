package com.example.projetovital.ui.projetovital.alergia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetovital.data.db.AppDatabase
import com.example.projetovital.data.db.dao.AlergiaDao
import com.example.projetovital.data.db.datasource.AlergiaDataSource
import com.example.projetovital.data.db.entity.AlergiaEntity
import com.example.projetovital.data.db.repository.AlergiaRepository
import com.example.projetovital.databinding.FragmentFormAlergiaBinding
import com.google.android.material.snackbar.Snackbar

class FormAlergiaFragment : Fragment() {

    private lateinit var binding: FragmentFormAlergiaBinding

    private val viewModel: AlergiaViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val alergiaDao: AlergiaDao =
                    AppDatabase.getInstance(requireContext()).alergiaDao()
                val repository: AlergiaRepository = AlergiaDataSource(alergiaDao)
                return AlergiaViewModel(repository) as T
            }
        }
    }

    //Configuração do layout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Cria o layout usando ViewBinding
        binding = FragmentFormAlergiaBinding.inflate(inflater, container, false)

        // Retorna a view raiz do binding
        return binding.root
    }

    //Configuração campos formulario
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        @Suppress("DEPRECATION")
        val alergia = arguments?.getSerializable("alergia") as? AlergiaEntity
        alergia?.let {
            preencherCamposAlergia(it)
        }


        inserirAlergia(alergia)
        observerEvents()

    }

    private fun preencherCamposAlergia(alergia: AlergiaEntity) {
        binding.etAlergiaNome.setText(alergia.nomeAlergia)
    }


    //Salvar Alergia
    private fun inserirAlergia(alergia: AlergiaEntity?) {
        binding.btnAlergiaSalvar.setOnClickListener {
            val nomeAlergia = binding.etAlergiaNome.text.toString()

            // Cria uma nova instância de AlergiaEntity ou atualiza a existente
            val novaAlergia =
                alergia?.copy(nomeAlergia = nomeAlergia) ?: AlergiaEntity(nomeAlergia = nomeAlergia)

            // Verifica se é uma atualização ou uma inserção
            if (alergia != null) {
                viewModel.updateAlergia(novaAlergia) // Atualiza a alergia
            } else {
                viewModel.inserirAlergia(novaAlergia) // Insere uma nova alergia
            }
        }
    }

    private fun observerEvents() {
        viewModel.alergiaStateEventData.observe(viewLifecycleOwner) { alergiaState ->
            when (alergiaState) {
                is AlergiaViewModel.AlergiaState.Inserido -> {
                    limparCampos()
                }
            }
        }
        viewModel.messageEventData.observe(viewLifecycleOwner) { stringResId ->
            Snackbar.make(requireView(), stringResId, Snackbar.LENGTH_LONG).show()
        }
    }

    //Limpar campos
    private fun limparCampos() {
        binding.etAlergiaNome.text?.clear()
    }
}

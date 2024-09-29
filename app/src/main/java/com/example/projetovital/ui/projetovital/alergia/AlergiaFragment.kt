package com.example.projetovital.ui.projetovital.alergia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.projetovital.MainActivity
import com.example.projetovital.data.db.AppDatabase
import com.example.projetovital.data.db.dao.AlergiaDao
import com.example.projetovital.data.db.datasource.AlergiaDataSource
import com.example.projetovital.data.db.repository.AlergiaRepository
import com.example.projetovital.databinding.FragmentAlergiaBinding


class AlergiaFragment : Fragment() {
    private lateinit var binding: FragmentAlergiaBinding
    private lateinit var recyclerAlergias: RecyclerView

    private val viewModel: AlergiaViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val alergiaDao: AlergiaDao =
                    AppDatabase.getInstance(requireContext()).alergiaDao() // Ajuste aqui
                val repository: AlergiaRepository = AlergiaDataSource(alergiaDao)
                return AlergiaViewModel(repository) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate o layout usando ViewBinding
        binding = FragmentAlergiaBinding.inflate(inflater, container, false)

        // Inicializa a RecyclerView
        recyclerAlergias = binding.recyclerAlergias

        // Observa eventos do ViewModel
        observerViewModelEventsAlergia()

        binding.btnNovoAlergia.setOnClickListener {
            // Navegue para o fragmento de formulário de alergia
            (activity as? MainActivity)?.replaceFragment(FormAlergiaFragment())
        }

        // Retorna a view raiz do binding
        return binding.root
    }

    private fun observerViewModelEventsAlergia() {
        viewModel.exibirAlergia.observe(viewLifecycleOwner) { exibirAlergia ->
            val alergiaListAdapter = AlergiaListAdapter(exibirAlergia)

            with(recyclerAlergias) {
                setHasFixedSize(true)
                adapter = alergiaListAdapter
            }
        }
    }
}


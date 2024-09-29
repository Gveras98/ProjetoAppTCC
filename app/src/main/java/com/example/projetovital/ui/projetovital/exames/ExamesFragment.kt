package com.example.projetovital.ui.projetovital.exames

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
import com.example.projetovital.data.db.dao.ExamesDao
import com.example.projetovital.data.db.datasource.ExamesDataSource
import com.example.projetovital.data.db.repository.ExamesRepository
import com.example.projetovital.databinding.FragmentExamesBinding


class ExamesFragment : Fragment() {

    private lateinit var binding: FragmentExamesBinding
    private lateinit var recyclerExames: RecyclerView

    //Declaração da varival viewModel
    private val viewModel: ExamesViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val examesDao: ExamesDao =
                    AppDatabase.getInstance(requireContext()).examesDao()
                val repository: ExamesRepository = ExamesDataSource(examesDao)
                return ExamesViewModel(repository) as T
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate o layout usando ViewBinding
        binding = FragmentExamesBinding.inflate(inflater, container, false)

        // Inicializa a RecyclerView e o adapter
        recyclerExames = binding.recyclerExames

        //Ponto de entrada do APP (ViewModel)
        observerViewModelEventsExames()


        // Define o botão para chamar a função replaceFragment
        binding.btnCadExames.setOnClickListener {
            (activity as? MainActivity)?.replaceFragment(FormExamesFragment())
        }

        // Retorna a view raiz do binding
        return binding.root
    }

    private fun observerViewModelEventsExames() {
        viewModel.exibirExames.observe(viewLifecycleOwner) { exames ->
            val examesListAdapter = ExamesListAdapter(exames)

            with(recyclerExames) {
                setHasFixedSize(true)
                adapter = examesListAdapter
            }
        }
    }
}
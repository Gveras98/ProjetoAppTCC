package com.example.projetovital.ui.projetovital.agenda

import android.graphics.Rect
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
import com.example.projetovital.data.db.dao.AgendaDao
import com.example.projetovital.data.db.datasource.AgendaDataSource
import com.example.projetovital.data.db.repository.AgendaRepository
import com.example.projetovital.databinding.FragmentAgendaBinding

class AgendaFragment : Fragment() {

    private lateinit var binding: FragmentAgendaBinding
    private lateinit var recyclerAgenda: RecyclerView

    // Declara o viewModel
    private val viewModel: AgendaViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val agendaDao: AgendaDao =
                    AppDatabase.getInstance(requireContext()).agendaDao()
                val repository: AgendaRepository = AgendaDataSource(agendaDao)
                return AgendaViewModel(repository) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate o layout usando ViewBinding
        binding = FragmentAgendaBinding.inflate(inflater, container, false)

        // Inicializa a RecyclerView e o adapter
        recyclerAgenda = binding.recyclerAgenda

        // Adiciona espaçamento entre os itens da RecyclerView
        recyclerAgenda.addItemDecoration(SpacingItemDecoration(16))  //16dp

        // Ponto de entrada do APP (ViewModel)
        observerViewModelEventsAgenda()

        binding.btnCadAgendamento.setOnClickListener {
            // Chama a função replaceFragment da MainActivity
            (activity as? MainActivity)?.replaceFragment(FormAgendaFragment())
        }

        // Retorna a view raiz do binding
        return binding.root
    }

    private fun observerViewModelEventsAgenda() {
        viewModel.exibirAgenda.observe(viewLifecycleOwner) { exibirAgenda ->
            val agendaListAdapter = AgendaListAdapter(exibirAgenda, viewModel)

            with(recyclerAgenda) {
                setHasFixedSize(true)
                adapter = agendaListAdapter
            }
        }
    }

    //Definir o espaçamento entre os itens
    class SpacingItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.bottom = spaceHeight  // Define o espaçamento entre os itens
        }
    }
}


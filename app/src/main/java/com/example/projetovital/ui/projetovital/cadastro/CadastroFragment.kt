package com.example.projetovital.ui.projetovital.cadastro

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
import com.example.projetovital.data.db.dao.CadastroDao
import com.example.projetovital.data.db.datasource.CadastroDataSource
import com.example.projetovital.data.db.repository.CadastroRepository
import com.example.projetovital.databinding.FragmentCadastroBinding
import com.example.projetovital.ui.projetovital.alergia.AlergiaFragment
import com.example.projetovital.ui.projetovital.medicamento.MedicamentoFragment

class CadastroFragment : Fragment() {

    private lateinit var binding: FragmentCadastroBinding
    private lateinit var recyclerCadastro: RecyclerView

    // Declaração da variável viewModel
    private val viewModel: CadastroViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val cadastroDao: CadastroDao =
                    AppDatabase.getInstance(requireContext()).cadastroDao()
                val repository: CadastroRepository = CadastroDataSource(cadastroDao)
                return CadastroViewModel(repository) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        // Inflate o layout usando ViewBinding
        binding = FragmentCadastroBinding.inflate(inflater, container, false)

        // Inicializa a RecyclerView e o adapter
        recyclerCadastro = binding.recyclerCadastro

        //Ponto de entrada do APP (ViewModel)
        observerViewModelEvents()

        // Define os botões de navegação
        binding.btnAtualizarCadastro.setOnClickListener {
            (activity as? MainActivity)?.replaceFragment(FormCadastroFragment())
        }
        binding.btnMedicamentos.setOnClickListener {
            (activity as? MainActivity)?.replaceFragment(MedicamentoFragment())
        }
        binding.btnAlergias.setOnClickListener {
            (activity as? MainActivity)?.replaceFragment(AlergiaFragment())
        }

        // Retorna a view raiz do binding
        return binding.root
    }

    private fun observerViewModelEvents() {
        viewModel.exibirCadastro.observe(viewLifecycleOwner) { exibirCadastro ->
            val cadastroListAdapter = CadastroListAdapter(exibirCadastro)

            with(recyclerCadastro) {
                setHasFixedSize(true)
                adapter = cadastroListAdapter
            }
        }
    }

}


package com.example.projetovital.ui.projetovital.medicamento

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
import com.example.projetovital.data.db.dao.MedicamentoDao
import com.example.projetovital.data.db.datasource.MedicamentoDataSource
import com.example.projetovital.data.db.repository.MedicamentoRepository
import com.example.projetovital.databinding.FragmentMedicamentoBinding

class MedicamentoFragment : Fragment() {

    private lateinit var binding: FragmentMedicamentoBinding
    private lateinit var recyclerMedicamento: RecyclerView

    // Declaração da variável viewModel
    private val viewModel: MedicamentoViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val medicamentoDao: MedicamentoDao =
                    AppDatabase.getInstance(requireContext()).medicamentoDao()
                val repository: MedicamentoRepository = MedicamentoDataSource(medicamentoDao)
                return MedicamentoViewModel(repository) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate o layout usando ViewBinding
        binding = FragmentMedicamentoBinding.inflate(inflater, container, false)

        //Inicializa a recyclerView e o adapter
        recyclerMedicamento = binding.recyclerMedicamento

        observerViewModelEventsMedicamento()

        binding.btnNovoMedicamento.setOnClickListener {
            // Navegue para o fragmento de formulário de medicamento
            (activity as? MainActivity)?.replaceFragment(FormMedicamentoFragment())
        }

        // Retorna a view raiz do binding
        return binding.root
    }

    private fun observerViewModelEventsMedicamento() {
        viewModel.exibirMedicamento.observe(viewLifecycleOwner) { medicamentoList ->
            val medicamentoAdapter = MedicamentoListAdapter(medicamentoList)

            with(recyclerMedicamento) {
                setHasFixedSize(true)
                adapter = medicamentoAdapter
            }
        }
    }
}

package com.example.projetovital.ui.projetovital.medicamento

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetovital.R
import com.example.projetovital.data.db.AppDatabase
import com.example.projetovital.data.db.datasource.MedicamentoDataSource
import com.example.projetovital.data.db.entity.MedicamentoEntity
import com.example.projetovital.data.db.repository.MedicamentoRepository
import com.example.projetovital.databinding.FragmentFormMedicamentoBinding
import com.google.android.material.snackbar.Snackbar

class FormMedicamentoFragment : Fragment() {

    private lateinit var binding: FragmentFormMedicamentoBinding

    private val viewModel: MedicamentoViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val medicamentoDao = AppDatabase.getInstance(requireContext()).medicamentoDao()
                val repository: MedicamentoRepository = MedicamentoDataSource(medicamentoDao)
                return MedicamentoViewModel(repository) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Cria o layout usando ViewBinding
        binding = FragmentFormMedicamentoBinding.inflate(inflater, container, false)

        // Adaptador para o Spinner de Duração
        val adapterDuracao = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.med_duracao,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        // Adaptador para o Spinner de Intervalo
        val adapterIntervalo = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.med_intervalo,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        // Configura os adaptadores para os spinners
        binding.spinnerEtDuracaoMed.adapter = adapterDuracao
        binding.spinnerEtIntercaloMed.adapter = adapterIntervalo

        // Altera a cor do texto do Spinner de Duração (para o texto selecionado e itens do dropdown)
        binding.spinnerEtDuracaoMed.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (view is TextView) {
                    // Altera a cor do texto do item selecionado
                    view.setTextColor(ContextCompat.getColor(requireContext(), R.color.item_texto))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        // Altera a cor do texto do Spinner de Intervalo (para o texto selecionado e itens do dropdown)
        binding.spinnerEtIntercaloMed.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (view is TextView) {
                    // Altera a cor do texto do item selecionado
                    view.setTextColor(ContextCompat.getColor(requireContext(), R.color.item_texto))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        // Retorna a view raiz do binding
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        @Suppress("DEPRECATION")
        val medicamento = arguments?.getSerializable("medicamento") as? MedicamentoEntity
        medicamento?.let {
            preencherCamposMedicamento(it)
        }

        inserirMedicamento(medicamento)
        observerEvents()

    }

    private fun preencherCamposMedicamento(medicamento: MedicamentoEntity) {
        binding.etMedNome.setText(medicamento.nomeMedicamento)
        binding.etMedDose.setText(medicamento.doseMedicamento)
    }

    private fun inserirMedicamento(medicamento: MedicamentoEntity?) {
        binding.btnMedSalvar.setOnClickListener {
            //Coleta os dados do formulário
            var nomeMedicamento = binding.etMedNome.text.toString()
            var doseMedicamento = binding.etMedDose.text.toString()
            var duracaoMedicamento = binding.spinnerEtDuracaoMed.selectedItem.toString()
            var intervaloMedicamento = binding.spinnerEtIntercaloMed.selectedItem.toString()

            val novomedicamento = medicamento?.copy(
                nomeMedicamento = nomeMedicamento,
                doseMedicamento = doseMedicamento,
                duracaoMedicamento = duracaoMedicamento,
                intervaloMedicamento = intervaloMedicamento
            ) ?: MedicamentoEntity(
                nomeMedicamento = nomeMedicamento,
                doseMedicamento = doseMedicamento,
                duracaoMedicamento = duracaoMedicamento,
                intervaloMedicamento = intervaloMedicamento
            )

            if (medicamento != null) {
                viewModel.updateMedicamento(novomedicamento) // Atualizar
            } else {
                viewModel.inserirMedicamento(novomedicamento) // Inserir
            }
        }
    }

    private fun observerEvents() {
        viewModel.medicamentoStateEventData.observe(viewLifecycleOwner) { medicamentoState ->
            when (medicamentoState) {
                is MedicamentoViewModel.MedicamentoState.Inserido -> {
                    limparCampos()
                }
            }
        }
        viewModel.messageEventData.observe(viewLifecycleOwner) { stringResId ->
            Snackbar.make(requireView(), stringResId, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun limparCampos() {
        binding.etMedNome.text?.clear()
        binding.etMedDose.text?.clear()
        binding.spinnerEtDuracaoMed.setSelection(0)
        binding.spinnerEtIntercaloMed.setSelection(0)
    }
}
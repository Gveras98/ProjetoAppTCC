package com.example.projetovital.ui.projetovital.cadastro

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetovital.R
import com.example.projetovital.data.db.AppDatabase
import com.example.projetovital.data.db.dao.CadastroDao
import com.example.projetovital.data.db.datasource.CadastroDataSource
import com.example.projetovital.data.db.entity.CadastroEntity
import com.example.projetovital.data.db.repository.CadastroRepository
import com.example.projetovital.databinding.FragmentFormCadastroBinding
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class FormCadastroFragment : Fragment() {

    private lateinit var binding: FragmentFormCadastroBinding

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inserirListeners()
        observeEvents()
    }

    private fun inserirListeners() {
        // Configurar DatePickerDialog para o campo de nascimento
        binding.etUserNascimento.setOnClickListener {
            val calendar = Calendar.getInstance()
            val ano = calendar.get(Calendar.YEAR)
            val mes = calendar.get(Calendar.MONTH)
            val dia = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
                // Formatar a data e definir no EditText
                val formattedDate = "$selectedDay-${selectedMonth + 1}-$selectedYear"
                binding.etUserNascimento.setText(formattedDate)
            }, ano, mes, dia).show()
        }

        binding.btnCadSalvar.setOnClickListener {
            // Coleta dos dados dos campos do formulário
            val nome = binding.etUserNome.text.toString()

            // Obtendo o texto do RadioButton selecionado
            val sexoId = binding.etUserSexo.checkedRadioButtonId
            val sexo = if (sexoId != -1) {
                val radioButton = binding.root.findViewById<RadioButton>(sexoId)
                radioButton.text.toString()
            } else {
                ""
            }

            // Conversão de String para Date usando SimpleDateFormat
            val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val nascimentoString = binding.etUserNascimento.text.toString()
            val nascimento: Date? = if (nascimentoString.isNotEmpty()) {
                try {
                    dateFormat.parse(nascimentoString)
                } catch (e: Exception) {
                    null
                }
            } else {
                null
            }

            val cpf = binding.etUserCpf.text.toString()
            val endereco = binding.EtUserEndereco.text.toString()
            val cep = binding.EtUserCep.text.toString()
            val telefone = binding.EtUserTelefone.text.toString()
            val email = binding.EtUserEmail.text.toString()
            val sus = binding.EtUserSus.text.toString()
            val planoSaude = binding.EtUserPlanoSaude.text.toString()
            val numPlanoSaude = binding.EtUserNumPlanoSaude.text.toString()
            val tipoSanguineo = binding.spinnerTipoSanguineo.selectedItem.toString()

            // Criação da instância do CadastroEntity
            val cadastro = CadastroEntity(
                nomeUser = nome,
                sexoUser = sexo.firstOrNull() ?: ' ',
                dataNascimentoUser = nascimento ?: Date(), // Certifique-se de lidar com isso
                cpfUser = cpf,
                enderecoUser = endereco,
                cepUser = cep,
                telefoneUser = telefone,
                emailUser = email,
                numSusUser = sus,
                planoSaudeUser = planoSaude,
                numPlanoSaudeUser = numPlanoSaude,
                tipoSanguineoUser = tipoSanguineo
            )

            // Chama o método do ViewModel para inserir o cadastro
            viewModel.inserirCadastro(cadastro)
        }
    }

    private fun observeEvents() {
        viewModel.cadastroStateEventData.observe(viewLifecycleOwner) { cadastroState ->
            when (cadastroState) {
                is CadastroViewModel.CadastroState.Inserido -> {
                    // Limpar os campos
                    limparCampos()
                }
            }
        }
        viewModel.messageEventData.observe(viewLifecycleOwner) { stringResId ->
            Snackbar.make(requireView(), stringResId, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun limparCampos() {
        binding.etUserNome.text?.clear()
        binding.etUserSexo.clearCheck()
        binding.etUserNascimento.text?.clear()
        binding.etUserCpf.text?.clear()
        binding.EtUserEndereco.text?.clear()
        binding.EtUserCep.text?.clear()
        binding.EtUserTelefone.text?.clear()
        binding.EtUserEmail.text?.clear()
        binding.EtUserSus.text?.clear()
        binding.EtUserPlanoSaude.text?.clear()
        binding.EtUserNumPlanoSaude.text?.clear()
        binding.spinnerTipoSanguineo.setSelection(0)
    }

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

        // Retorna a view raiz do binding
        return binding.root
    }
}

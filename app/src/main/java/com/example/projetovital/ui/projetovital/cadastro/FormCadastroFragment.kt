package com.example.projetovital.ui.projetovital.cadastro

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.content.ContextCompat
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
import com.example.projetovital.ui.projetovital.Mask
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class FormCadastroFragment : Fragment() {

    private lateinit var binding: FragmentFormCadastroBinding
    private val mask = Mask() // Instancia a classe Mask

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

    // Configuração do layout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormCadastroBinding.inflate(inflater, container, false)

        // Define a configuração do ARRAY de Tipo Sanguíneo
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.tipos_sanguineos,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        // Configura o adapter para o spinner
        binding.spinnerTipoSanguineo.adapter = adapter

        // Altera a cor do texto do Spinner de Tipo Sanguíneo (para o texto selecionado e itens do dropdown)
        binding.spinnerTipoSanguineo.onItemSelectedListener = object :
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

        return binding.root
    }


    // Configuração dos campos do formulário
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Aplica as máscaras
        mask.cpfMask(binding.etUserCpf)           // Aplica a máscara para CPF
        mask.telefoneMask(binding.EtUserTelefone) // Aplica a máscara para Telefone
        mask.cepMask(binding.EtUserCep)           // Aplica a máscara para CEP

        @Suppress("DEPRECATION")
        val cadastro = arguments?.getSerializable("cadastro") as? CadastroEntity
        cadastro?.let {
            preencherCamposCadastro(it)
        }

        inserirCadastro(cadastro)
        observeEvents()
    }

    private fun preencherCamposCadastro(cadastro: CadastroEntity) {
        binding.etUserNome.setText(cadastro.nomeUser)
        binding.etUserSexo.check(
            if (cadastro.sexoUser == 'M') R.id.rbMasculino else R.id.rbFeminino
        )
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val dataFormatada = cadastro.dataNascimentoUser.let { dateFormat.format(it) }
        binding.etUserNascimento.setText(dataFormatada)
        binding.etUserCpf.setText(cadastro.cpfUser)
        binding.EtUserEndereco.setText(cadastro.enderecoUser)
        binding.EtUserCep.setText(cadastro.cepUser)
        binding.EtUserTelefone.setText(cadastro.telefoneUser)
        binding.EtUserEmail.setText(cadastro.emailUser)
        binding.EtUserSus.setText(cadastro.numSusUser)
        binding.EtUserPlanoSaude.setText(cadastro.planoSaudeUser)
        binding.EtUserNumPlanoSaude.setText(cadastro.numPlanoSaudeUser)
        binding.spinnerTipoSanguineo.setSelection(
            resources.getStringArray(R.array.tipos_sanguineos).indexOf(cadastro.tipoSanguineoUser)
        )
        binding.EtUserSenha.setText(cadastro.senhaUser)
    }

    private fun inserirCadastro(cadastro: CadastroEntity?) {

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

        //Salvar Cadastro
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
            val senha = binding.EtUserSenha.text.toString()


            // Criação da instância do CadastroEntity
            val novocadastro = cadastro?.copy(
                nomeUser = nome,
                sexoUser = sexo.firstOrNull() ?: ' ',
                dataNascimentoUser = nascimento ?: Date(),
                cpfUser = cpf,
                enderecoUser = endereco,
                cepUser = cep,
                telefoneUser = telefone,
                emailUser = email,
                numSusUser = sus,
                planoSaudeUser = planoSaude,
                numPlanoSaudeUser = numPlanoSaude,
                tipoSanguineoUser = tipoSanguineo,
                senhaUser = senha
            ) ?: CadastroEntity(
                nomeUser = nome,
                sexoUser = sexo.firstOrNull() ?: ' ',
                dataNascimentoUser = nascimento ?: Date(),
                cpfUser = cpf,
                enderecoUser = endereco,
                cepUser = cep,
                telefoneUser = telefone,
                emailUser = email,
                numSusUser = sus,
                planoSaudeUser = planoSaude,
                numPlanoSaudeUser = numPlanoSaude,
                tipoSanguineoUser = tipoSanguineo,
                senhaUser = senha
            )
            // Chama o método do ViewModel para inserir o cadastro
            if (cadastro != null) {
                viewModel.updateCadastro(novocadastro)
            } else {
                viewModel.inserirCadastro(novocadastro)
            }
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
}

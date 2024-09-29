package com.example.projetovital.ui.projetovital.cadastro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetovital.MainActivity
import com.example.projetovital.data.db.AppDatabase
import com.example.projetovital.data.db.dao.CadastroDao
import com.example.projetovital.data.db.datasource.CadastroDataSource
import com.example.projetovital.data.db.repository.CadastroRepository
import com.example.projetovital.databinding.FragmentCadastroBinding
import com.example.projetovital.ui.projetovital.alergia.AlergiaFragment
import com.example.projetovital.ui.projetovital.medicamento.MedicamentoFragment
import java.text.SimpleDateFormat
import java.util.Locale

class CadastroFragment : Fragment() {

    private lateinit var binding: FragmentCadastroBinding

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

        // Observe os dados de cadastro
        viewModel.exibirCadastro.observe(viewLifecycleOwner) { cadastroList ->
            // Preenche os TextViews com os dados do primeiro cadastro da lista
            // Aqui você pode ajustar para exibir o cadastro desejado, por exemplo, o mais recente ou o que precisa ser editado
            cadastroList.firstOrNull()?.let { cadastro ->
                binding.tvCadastroNome.text = cadastro.nomeUser
                binding.tvCadastroSexo.text = cadastro.sexoUser.toString()
                binding.tvCadastroDataNascimento.text = cadastro.dataNascimentoUser.let {
                    SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(it)
                } ?: "Data não disponível"
                binding.tvCadastroCPF.text = cadastro.cpfUser
                binding.tvCadastroEndereco.text = cadastro.enderecoUser
                binding.tvCadastroCEP.text = cadastro.cepUser
                binding.tvCadastroTelefone.text = cadastro.telefoneUser
                binding.tvCadastroEmail.text = cadastro.emailUser
                binding.tvCadastroNumeroSUS.text = cadastro.numSusUser
                binding.tvCadastroPlanoSaude.text = cadastro.planoSaudeUser
                binding.tvCadastroNumeroPlanoSaude.text = cadastro.numPlanoSaudeUser
                binding.tvCadastroTipoSanguineo.text = cadastro.tipoSanguineoUser
            }
        }

        // Retorna a view raiz do binding
        return binding.root
    }
}


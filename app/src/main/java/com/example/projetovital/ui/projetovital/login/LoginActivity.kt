package com.example.projetovital.ui.projetovital.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetovital.MainActivity
import com.example.projetovital.data.db.AppDatabase
import com.example.projetovital.data.db.dao.CadastroDao
import com.example.projetovital.data.db.datasource.CadastroDataSource
import com.example.projetovital.data.db.repository.CadastroRepository
import com.example.projetovital.databinding.ActivityLoginBinding
import com.example.projetovital.ui.projetovital.cadastro.CadastroViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val viewModel: CadastroViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val cadastroDao: CadastroDao =
                    AppDatabase.getInstance(this@LoginActivity).cadastroDao()
                val repository: CadastroRepository = CadastroDataSource(cadastroDao)
                return CadastroViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observa o estado de autenticação
        observeAuthState()

        // Ação do botão de login
        binding.btnLogin.setOnClickListener {
            val email = binding.etLoginUsuario.text.toString().trim()
            val senha = binding.etLoginSenha.text.toString().trim()

            if (email.isNotEmpty() && senha.isNotEmpty()) {
                viewModel.verificarLogin(email, senha)
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Ação do botão de cadastro
        binding.btnCadastro.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(
                "openFormCadastro",
                true
            ) // Passando sinalizador para abrir o FormCadastro
            startActivity(intent)
            finish()
        }
    }

    private fun observeAuthState() {
        // Configura a observação do estado de autenticação
        viewModel.authState.observe(this@LoginActivity) { state ->
            when (state) {
                is CadastroViewModel.AuthState.Autenticado -> {
                    Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                    // Inicia a MainActivity após o login bem-sucedido
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Fecha a LoginActivity
                }

                is CadastroViewModel.AuthState.ErroAutenticacao -> {
                    Toast.makeText(this, "Credenciais inválidas", Toast.LENGTH_SHORT).show()
                }

                else -> {}
            }
        }
    }
}



package com.example.projetovital.ui.projetovital.cadastro

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetovital.R
import com.example.projetovital.data.db.entity.CadastroEntity
import com.example.projetovital.data.db.repository.CadastroRepository
import kotlinx.coroutines.launch


class CadastroViewModel(
    private val repository: CadastroRepository
) : ViewModel() {

    // Estados de cadastro
    private val _cadastroStateEventData = MutableLiveData<CadastroState>()
    val cadastroStateEventData: LiveData<CadastroState>
        get() = _cadastroStateEventData

    private val _messageEventData = MutableLiveData<Int>()
    val messageEventData: LiveData<Int>
        get() = _messageEventData

    // Estados de autenticação
    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState>
        get() = _authState

    // Exibição de cadastros
    val exibirCadastro = repository.getAllCadastros()

    // Função para inserir um cadastro
    fun inserirCadastro(cadastro: CadastroEntity) = viewModelScope.launch {
        try {
            val idUser = repository.insertCadastro(cadastro)
            if (idUser > 0) {
                _cadastroStateEventData.value = CadastroState.Inserido
                _messageEventData.value = R.string.msg_sucesso
            }
        } catch (ex: Exception) {
            _messageEventData.value = R.string.msg_erro
            Log.e(TAG, ex.toString())
        }
    }

    // Função para atualizar um cadastro
    fun updateCadastro(cadastro: CadastroEntity) = viewModelScope.launch {
        try {
            repository.updateCadastro(cadastro)
            _messageEventData.value = R.string.msg_sucesso
        } catch (ex: Exception) {
            _messageEventData.value = R.string.msg_erro
            Log.e(TAG, ex.toString())
        }
    }

    // Função para verificar login
    fun verificarLogin(email: String, senha: String) = viewModelScope.launch {
        try {
            val cadastro = repository.getCadastroByEmail(email)
            if (cadastro != null && cadastro.senhaUser == senha) {
                _authState.value = AuthState.Autenticado
            } else {
                _authState.value = AuthState.ErroAutenticacao
            }
        } catch (ex: Exception) {
            _authState.value = AuthState.ErroAutenticacao
            Log.e(TAG, ex.toString())
        }
    }

    // Estados para inserção de cadastro
    sealed class CadastroState {
        object Inserido : CadastroState()
    }

    // Estados para autenticação de login
    sealed class AuthState {
        object Autenticado : AuthState()  // Autenticação bem-sucedida
        object ErroAutenticacao : AuthState()  // Falha na autenticação
    }

    companion object {
        private val TAG = CadastroViewModel::class.java.simpleName
    }
}


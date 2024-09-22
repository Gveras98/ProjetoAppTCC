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

    //Inserir Cadastro
    private val _cadastroStateEventData = MutableLiveData<CadastroState>()
    val cadastroStateEventData: LiveData<CadastroState>
        get() = _cadastroStateEventData

    private val _messageEventData = MutableLiveData<Int>()
    val messageEventData: LiveData<Int>
        get() = _messageEventData

    //Função Inserir
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

    sealed class CadastroState {
        object Inserido : CadastroState()
    }

    companion object {
        private val TAG = CadastroViewModel::class.java.simpleName
    }
    // Fim Cadastro

    //Exibição
    val exibirCadastro = repository.getAllCadastros()
}


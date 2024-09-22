package com.example.projetovital.ui.projetovital.exames

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetovital.R
import com.example.projetovital.data.db.entity.ExamesEntity
import com.example.projetovital.data.db.repository.ExamesRepository
import kotlinx.coroutines.launch

class ExamesViewModel(
    private val repository: ExamesRepository
) : ViewModel() {

    // Inserir Exames
    private val _examesStateEventData = MutableLiveData<ExamesState>()
    val examesStateEventData: LiveData<ExamesState>
        get() = _examesStateEventData

    private val _messageEventData = MutableLiveData<Int>()
    val messageEventData: LiveData<Int>
        get() = _messageEventData

    // Função Inserir
    fun inserirExames(exames: ExamesEntity) = viewModelScope.launch {
        try {
            val idExames = repository.insertExames(exames)
            if (idExames > 0) {
                _examesStateEventData.value = ExamesState.Inserido
                _messageEventData.value = R.string.msg_sucesso

            }
        } catch (ex: Exception) {
            _messageEventData.value = R.string.msg_erro
            Log.e(TAG, ex.toString())
        }

    }

    sealed class ExamesState {
        object Inserido : ExamesState()
    }

    companion object {
        private val TAG = ExamesViewModel::class.java.simpleName
    }

    //Exibição
    val exibirExames = repository.getAllExames()

}
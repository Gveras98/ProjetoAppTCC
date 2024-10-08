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

    private val _examesMessageEventData = MutableLiveData<Int>()
    val messageEventData: LiveData<Int>
        get() = _examesMessageEventData

    // Função Inserir
    fun inserirExames(exames: ExamesEntity) = viewModelScope.launch {
        try {
            val idExames = repository.insertExames(exames)
            if (idExames > 0) {
                _examesStateEventData.value = ExamesState.Inserido
                _examesMessageEventData.value = R.string.msg_sucesso

            }
        } catch (ex: Exception) {
            _examesMessageEventData.value = R.string.msg_erro
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

    //Delete
    fun deleteExames(exames: ExamesEntity) = viewModelScope.launch {
        try {
            repository.deleteExames(exames)
            _examesMessageEventData.value = R.string.delete_sucesso
        } catch (ex: Exception) {
            _examesMessageEventData.value = R.string.delete_erro
            Log.e(TAG, ex.toString())
        }
    }

    //Atualizar
    fun updateExames(exames: ExamesEntity) = viewModelScope.launch {
        try {
            repository.updateExames(exames)
            _examesMessageEventData.value = R.string.update_sucesso
        } catch (ex: Exception) {
            _examesMessageEventData.value = R.string.update_erro
            Log.e(TAG, ex.toString())
        }
    }
}
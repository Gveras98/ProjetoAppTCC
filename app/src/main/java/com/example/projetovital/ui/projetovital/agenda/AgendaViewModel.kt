package com.example.projetovital.ui.projetovital.agenda

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetovital.R
import com.example.projetovital.data.db.entity.AgendaEntity
import com.example.projetovital.data.db.repository.AgendaRepository
import kotlinx.coroutines.launch

class AgendaViewModel(
    private val repository: AgendaRepository
) : ViewModel() {

    // Função para inserir um novo agendamento
    private val _agendaStateEventData = MutableLiveData<AgendaState>()
    val agendaStateEventData: LiveData<AgendaState>
        get() = _agendaStateEventData


    private val _agendaMessageEventData = MutableLiveData<Int>()
    val messageEventData: LiveData<Int>
        get() = _agendaMessageEventData

    //Inserir
    fun inserirAgenda(agenda: AgendaEntity) = viewModelScope.launch {
        try {
            val idAgenda = repository.insertAgenda(agenda)
            if (idAgenda > 0) {
                _agendaStateEventData.value = AgendaState.Inserido
                _agendaMessageEventData.value = R.string.msg_sucesso
            }
        } catch (ex: Exception) {
            _agendaMessageEventData.value = R.string.msg_erro
            Log.e(TAG, ex.toString())
        }
    }

    sealed class AgendaState {
        object Inserido : AgendaState()
    }

    companion object {
        private val TAG = AgendaViewModel::class.java.simpleName
    }

    // Exibição
    val exibirAgenda = repository.getAllAgendas()

    //Delete
    fun deleteAgenda(agenda: AgendaEntity) = viewModelScope.launch {
        try {
            repository.deleteAgenda(agenda)
            _agendaMessageEventData.value = R.string.delete_sucesso
        } catch (ex: Exception) {
            _agendaMessageEventData.value = R.string.delete_erro
            Log.e(TAG, ex.toString())
        }
    }
}

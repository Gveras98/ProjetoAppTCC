package com.example.projetovital.ui.projetovital.alergia

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetovital.R
import com.example.projetovital.data.db.entity.AlergiaEntity
import com.example.projetovital.data.db.repository.AlergiaRepository
import kotlinx.coroutines.launch

class AlergiaViewModel(
    private val repository: AlergiaRepository
) : ViewModel() {

    // Inserir Alergia
    private val _alergiaStateEventData = MutableLiveData<AlergiaState>()
    val alergiaStateEventData: LiveData<AlergiaState>
        get() = _alergiaStateEventData

    private val _alergiaMessageEventData = MutableLiveData<Int>()
    val messageEventData: LiveData<Int>
        get() = _alergiaMessageEventData

    // Função Inserir
    fun inserirAlergia(alergia: AlergiaEntity) = viewModelScope.launch {
        try {
            val idAlergia = repository.insertAlergia(alergia)
            if (idAlergia > 0) {
                _alergiaStateEventData.value = AlergiaState.Inserido
                _alergiaMessageEventData.value = R.string.msg_sucesso
            }
        } catch (ex: Exception) {
            _alergiaMessageEventData.value = R.string.msg_erro
            Log.e(TAG, ex.toString())
        }
    }

    sealed class AlergiaState {
        object Inserido : AlergiaState()
    }

    companion object {
        private val TAG = AlergiaViewModel::class.java.simpleName
    }

    // Exibição
    val exibirAlergia = repository.getAllAlergias()

    // Delete
    fun deleteAlergia(alergia: AlergiaEntity) = viewModelScope.launch {
        try {
            repository.deleteAlergia(alergia) // Chama o repositório para excluir
            _alergiaMessageEventData.value = R.string.delete_sucesso
        } catch (ex: Exception) {
            _alergiaMessageEventData.value = R.string.delete_erro
            Log.e(TAG, ex.toString())
        }
    }
}

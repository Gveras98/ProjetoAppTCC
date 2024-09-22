package com.example.projetovital.ui.projetovital.medicamento

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetovital.R
import com.example.projetovital.data.db.entity.MedicamentoEntity
import com.example.projetovital.data.db.repository.MedicamentoRepository
import kotlinx.coroutines.launch


class MedicamentoViewModel(
    private val repository: MedicamentoRepository
) : ViewModel() {

    //Inserir Medicamento
    private val _medicamentoStateEventData = MutableLiveData<MedicamentoState>()
    val medicamentoStateEventData: LiveData<MedicamentoState>
        get() = _medicamentoStateEventData

    private val _medicamentoMessageEventData = MutableLiveData<Int>()
    val messageEventData: LiveData<Int>
        get() = _medicamentoMessageEventData

    //Função Inserir
    fun inserirMedicamento(medicamento: MedicamentoEntity) = viewModelScope.launch {
        try {
            val idMedicamento = repository.insertMedicamento(medicamento)
            if (idMedicamento > 0) {
                _medicamentoStateEventData.value = MedicamentoState.Inserido
                _medicamentoMessageEventData.value = R.string.msg_sucesso
            }
        } catch (ex: Exception) {
            _medicamentoMessageEventData.value = R.string.msg_erro
            Log.e(TAG, ex.toString())
        }
    }

    sealed class MedicamentoState {
        object Inserido : MedicamentoState()
    }

    companion object {
        private val TAG = MedicamentoViewModel::class.java.simpleName
    }

    //Exibição
    val exibirMedicamento = repository.getAllMedicamentos()

}
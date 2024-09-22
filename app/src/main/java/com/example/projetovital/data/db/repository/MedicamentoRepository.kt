package com.example.projetovital.data.db.repository

import androidx.lifecycle.LiveData
import com.example.projetovital.data.db.entity.MedicamentoEntity

interface MedicamentoRepository {
    fun getAllMedicamentos(): LiveData<List<MedicamentoEntity>>
    suspend fun insertMedicamento(medicamento: MedicamentoEntity): Long
    suspend fun updateMedicamento(medicamento: MedicamentoEntity)
    suspend fun deleteMedicamento(medicamento: MedicamentoEntity)
}

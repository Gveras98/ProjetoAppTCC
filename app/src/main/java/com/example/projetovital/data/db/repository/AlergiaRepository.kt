package com.example.projetovital.repository

import androidx.lifecycle.LiveData
import com.example.projetovital.data.db.entity.AlergiaEntity

interface AlergiaRepository {
    fun getAllAlergias(): LiveData<List<AlergiaEntity>>
    suspend fun insertAlergia(alergia: AlergiaEntity)
    suspend fun updateAlergia(alergia: AlergiaEntity)
    suspend fun deleteAlergia(alergia: AlergiaEntity)
}

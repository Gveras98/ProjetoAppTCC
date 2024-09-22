package com.example.projetovital.repository

import androidx.lifecycle.LiveData
import com.example.projetovital.data.db.entity.ExamesEntity

interface ExamesRepository {
    fun getAllExames(): LiveData<List<ExamesEntity>>
    suspend fun insertExame(exames: ExamesEntity)
    suspend fun updateExame(exames: ExamesEntity)
    suspend fun deleteExame(exames: ExamesEntity)
}

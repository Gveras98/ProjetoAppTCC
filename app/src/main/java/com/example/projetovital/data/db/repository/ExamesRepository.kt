package com.example.projetovital.data.db.repository

import androidx.lifecycle.LiveData
import com.example.projetovital.data.db.entity.ExamesEntity

interface ExamesRepository {
    fun getAllExames(): LiveData<List<ExamesEntity>>
    suspend fun insertExames(exames: ExamesEntity): Long
    suspend fun updateExames(exames: ExamesEntity)
    suspend fun deleteExames(exames: ExamesEntity)
}

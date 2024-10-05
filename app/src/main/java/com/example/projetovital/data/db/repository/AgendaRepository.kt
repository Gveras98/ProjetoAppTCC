package com.example.projetovital.data.db.repository

import androidx.lifecycle.LiveData
import com.example.projetovital.data.db.entity.AgendaEntity

interface AgendaRepository {
    fun getAllAgendas(): LiveData<List<AgendaEntity>>

    suspend fun insertAgenda(agenda: AgendaEntity): Long


    suspend fun updateAgenda(agenda: AgendaEntity)

    suspend fun deleteAgenda(agenda: AgendaEntity)
}

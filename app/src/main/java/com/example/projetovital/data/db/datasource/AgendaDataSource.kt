package com.example.projetovital.datasource

import androidx.lifecycle.LiveData
import com.example.projetovital.data.db.dao.AgendaDao
import com.example.projetovital.data.db.entity.AgendaEntity
import com.example.projetovital.repository.AgendaRepository

class AgendaDataSource(private val agendaDao: AgendaDao) : AgendaRepository {

    override fun getAllAgendas(): LiveData<List<AgendaEntity>> {
        return agendaDao.getAll()
    }

    override suspend fun insertAgenda(agenda: AgendaEntity) {
        agendaDao.insert(agenda)
    }

    override suspend fun updateAgenda(agenda: AgendaEntity) {
        agendaDao.update(agenda)
    }

    override suspend fun deleteAgenda(agenda: AgendaEntity) {
        agendaDao.delete(agenda.idAgenda)
    }
}

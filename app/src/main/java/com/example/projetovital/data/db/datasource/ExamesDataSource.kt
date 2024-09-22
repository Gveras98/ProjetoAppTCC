package com.example.projetovital.datasource

import androidx.lifecycle.LiveData
import com.example.projetovital.data.db.dao.ExamesDao
import com.example.projetovital.data.db.entity.ExamesEntity
import com.example.projetovital.repository.ExamesRepository

class ExamesDataSource(private val examesDao: ExamesDao) : ExamesRepository {

    override fun getAllExames(): LiveData<List<ExamesEntity>> {
        return examesDao.getAll()
    }

    override suspend fun insertExame(exames: ExamesEntity) {
        examesDao.insert(exames)
    }

    override suspend fun updateExame(exames: ExamesEntity) {
        examesDao.update(exames)
    }

    override suspend fun deleteExame(exames: ExamesEntity) {
        examesDao.delete(exames.idExame)
    }
}

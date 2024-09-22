package com.example.projetovital.data.db.datasource

import androidx.lifecycle.LiveData
import com.example.projetovital.data.db.dao.AlergiaDao
import com.example.projetovital.data.db.entity.AlergiaEntity
import com.example.projetovital.data.db.repository.AlergiaRepository

class AlergiaDataSource(private val alergiaDao: AlergiaDao) : AlergiaRepository {

    override fun getAllAlergias(): LiveData<List<AlergiaEntity>> {
        return alergiaDao.getAll()
    }

    override suspend fun insertAlergia(alergia: AlergiaEntity): Long {
        return alergiaDao.insert(alergia)
    }

    override suspend fun updateAlergia(alergia: AlergiaEntity) {
        alergiaDao.update(alergia)
    }

    override suspend fun deleteAlergia(alergia: AlergiaEntity) {
        alergiaDao.delete(alergia.idAlergia)
    }
}

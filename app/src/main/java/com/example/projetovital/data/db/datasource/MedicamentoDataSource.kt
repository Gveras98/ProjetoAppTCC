package com.example.projetovital.data.db.datasource

import androidx.lifecycle.LiveData
import com.example.projetovital.data.db.dao.MedicamentoDao
import com.example.projetovital.data.db.entity.MedicamentoEntity
import com.example.projetovital.data.db.repository.MedicamentoRepository

class MedicamentoDataSource(private val medicamentoDao: MedicamentoDao) : MedicamentoRepository {

    override fun getAllMedicamentos(): LiveData<List<MedicamentoEntity>> {
        return medicamentoDao.getAll()
    }

    override suspend fun insertMedicamento(medicamento: MedicamentoEntity): Long {
        return medicamentoDao.insert(medicamento)
    }

    override suspend fun updateMedicamento(medicamento: MedicamentoEntity) {
        medicamentoDao.update(medicamento)
    }

    override suspend fun deleteMedicamento(medicamento: MedicamentoEntity) {
        medicamentoDao.delete(medicamento.idMedicamento)
    }
}

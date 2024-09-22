package com.example.projetovital.datasource

import androidx.lifecycle.LiveData
import com.example.projetovital.data.db.dao.CadastroDao
import com.example.projetovital.data.db.entity.CadastroEntity
import com.example.projetovital.repository.CadastroRepository

class CadastroDataSource(private val cadastroDao: CadastroDao) : CadastroRepository {

    override fun getAllCadastros(): LiveData<List<CadastroEntity>> {
        return cadastroDao.getAll()
    }

    override suspend fun insertCadastro(cadastro: CadastroEntity): Long {
        return cadastroDao.insert(cadastro)
    }

    override suspend fun updateCadastro(cadastro: CadastroEntity) {
        cadastroDao.update(cadastro)
    }
}

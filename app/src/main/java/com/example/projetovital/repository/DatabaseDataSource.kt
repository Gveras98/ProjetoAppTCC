package com.example.projetovital.repository

import androidx.lifecycle.LiveData
import com.example.projetovital.data.db.dao.CadastroDao
import com.example.projetovital.data.db.entity.CadastroEntity

class DatabaseDataSource(
    private val cadastroDao: CadastroDao) : CadastroRepository {
    override fun getAll(): LiveData<List<CadastroEntity>> {
        return cadastroDao.getAll()
    }
    override suspend fun insert(cadastro: CadastroEntity) {

        cadastroDao.insert(cadastro)
    }
    override suspend fun update(cadastro: CadastroEntity) {

        cadastroDao.update(cadastro)
    }
}
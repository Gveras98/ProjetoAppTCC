package com.example.projetovital.repository

import androidx.lifecycle.LiveData
import com.example.projetovital.data.db.entity.CadastroEntity

interface CadastroRepository {

    fun getAll(): LiveData<List<CadastroEntity>>
    suspend fun insert(cadastro: CadastroEntity)
    suspend fun update(cadastro: CadastroEntity)

}
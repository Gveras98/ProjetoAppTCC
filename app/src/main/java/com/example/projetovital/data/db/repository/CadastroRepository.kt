package com.example.projetovital.data.db.repository

import androidx.lifecycle.LiveData
import com.example.projetovital.data.db.entity.CadastroEntity

interface CadastroRepository {
    fun getAllCadastros(): LiveData<List<CadastroEntity>>
    suspend fun insertCadastro(cadastro: CadastroEntity): Long
    suspend fun updateCadastro(cadastro: CadastroEntity)

}

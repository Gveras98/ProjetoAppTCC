package com.example.projetovital.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.projetovital.data.db.entity.CadastroEntity

@Dao
interface CadastroDao {
    // Exibir a lista de cadastros
    @Query("SELECT * FROM tblCadastro")
    fun getAll(): LiveData<List<CadastroEntity>>
    // retirar o Suspende caso erro

    // Inserir um novo cadastro
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cadastro: CadastroEntity)

    // Atualizar um cadastro existente
    @Update
    suspend fun update(cadastro: CadastroEntity)
}
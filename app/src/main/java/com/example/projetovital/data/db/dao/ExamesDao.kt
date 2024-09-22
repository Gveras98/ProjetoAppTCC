package com.example.projetovital.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.projetovital.data.db.entity.ExamesEntity

@Dao
interface ExamesDao {

    //Read
    @Query("SELECT * FROM tblExames")
    fun getAll(): LiveData<List<ExamesEntity>>

    //Inserir
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(exames: ExamesEntity): Long

    //Update
    @Update
    suspend fun update(exames: ExamesEntity)

    //Delete
    @Query("DELETE FROM tblExames WHERE idExame = :id")
    suspend fun delete(id: Long)
}
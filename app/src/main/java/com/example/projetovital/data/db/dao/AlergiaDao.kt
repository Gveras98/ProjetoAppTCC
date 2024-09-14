package com.example.projetovital.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.projetovital.data.db.entity.AlergiaEntity

@Dao
interface AlergiaDao {
    //Read
    @Query("SELECT * FROM tblAlergia")
    fun getAll(): List<AlergiaEntity>
    //Inserir
    @Query("SELECT * FROM tblAlergia WHERE idAlergia = :id")
    fun getById(id: Long): AlergiaEntity?
    //Update
    @Update
    suspend fun update(alergia: AlergiaEntity)
    //Delete
    @Query("DELETE FROM tblAlergia WHERE idAlergia = :id")
    suspend fun delete(id: Long)


}
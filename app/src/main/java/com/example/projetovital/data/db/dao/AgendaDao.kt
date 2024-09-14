package com.example.projetovital.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.projetovital.data.db.entity.AgendaEntity


@Dao
interface AgendaDao {
    //Read
    @Query("SELECT * FROM tblAgenda")
    fun getAll(): List<AgendaEntity>
    //Inserir
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(agenda: AgendaEntity)
    //Update
    @Update
    suspend fun update(agenda: AgendaEntity)
    //Delete
    @Query("DELETE FROM tblAgenda WHERE idAgenda = :id")
    suspend fun delete(id: Long)

}
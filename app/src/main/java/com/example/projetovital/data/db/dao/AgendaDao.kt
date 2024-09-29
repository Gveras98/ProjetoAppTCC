package com.example.projetovital.data.db.dao

import androidx.lifecycle.LiveData
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
    fun getAll(): LiveData<List<AgendaEntity>>

    //Inserir - Replace para substituir em caso de conflito
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(agenda: AgendaEntity): Long

    //Update
    @Update
    suspend fun update(agenda: AgendaEntity)

    //Delete
    @Query("DELETE FROM tblAgenda WHERE idAgenda = :id")
    suspend fun delete(id: Long)

}
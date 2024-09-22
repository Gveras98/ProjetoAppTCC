package com.example.projetovital.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.projetovital.data.db.entity.AlergiaEntity

@Dao
interface AlergiaDao {
    //Read
    @Query("SELECT * FROM tblAlergia")
    fun getAll(): LiveData<List<AlergiaEntity>>

    //Inserir
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(alergia: AlergiaEntity): Long

    //Update
    @Update
    suspend fun update(alergia: AlergiaEntity)

    //Delete
    @Query("DELETE FROM tblAlergia WHERE idAlergia = :id")
    suspend fun delete(id: Long)


}
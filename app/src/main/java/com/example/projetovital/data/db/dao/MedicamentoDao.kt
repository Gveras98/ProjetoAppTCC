package com.example.projetovital.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.projetovital.data.db.entity.MedicamentoEntity


@Dao
interface MedicamentoDao {
    @Query("SELECT * FROM tblMedicamento")
    fun getAll(): List<MedicamentoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(medicamento: MedicamentoEntity)

    @Update
    suspend fun update(medicamento: MedicamentoEntity)

    @Query("DELETE FROM tblMedicamento WHERE idMedicamento = :id")
    suspend fun delete(id: Long)

}
package com.example.projetovital.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblMedicamento")
data class MedicamentoEntity(
    @ColumnInfo(name = "idMedicamento")
    @PrimaryKey(autoGenerate = true)
    val idMedicamento: Long = 0,

    @ColumnInfo(name = "nomeMedicamento")
    val nomeMedicamento: String,

    @ColumnInfo(name = "doseMedicamento")
    val doseMedicamento: String,

    @ColumnInfo(name = "duracaoMedicamento")
    val duracaoMedicamento: String,
    
    @ColumnInfo(name = "intervaloMedicamento")
    val intervaloMedicamento: String

)
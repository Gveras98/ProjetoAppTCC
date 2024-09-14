package com.example.projetovital.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tblExames")
data class ExamesEntity(
    @ColumnInfo(name = "idExame")
    @PrimaryKey(autoGenerate = true)
    val idExame: Long = 0,

    @ColumnInfo(name = "especialidadeExame")
    val especialidadeExame: String,

    @ColumnInfo(name = "dataExame")
    val dataExame: Date,

    @ColumnInfo(name = "localExame")
    val localExame: String,

    @ColumnInfo(name = "procedimentoExame")
    val procedimentoExame: String
)

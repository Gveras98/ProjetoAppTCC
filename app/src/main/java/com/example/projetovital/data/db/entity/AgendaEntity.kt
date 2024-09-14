package com.example.projetovital.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "tblAgenda")
data class AgendaEntity(

    @PrimaryKey(autoGenerate = true)
    val idAgenda: Long = 0,

    @ColumnInfo(name = "especialidadeAgenda")
    val especialidadeAgenda: String,

    @ColumnInfo(name = "dataAgenda")
    val dataAgenda:Date,

    @ColumnInfo(name = "horaAgenda")
    val horaAgenda:String,

    @ColumnInfo(name = "localAgenda")
    val localAgenda:String,

    @ColumnInfo(name = "procedimentoAgenda")
    val procedimentoAgenda:String
)
package com.example.projetovital.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.time.LocalTime
import java.util.Date


@Entity(tableName = "tblAgenda")
data class AgendaEntity(

    @ColumnInfo(name = "idAgenda")
    @PrimaryKey(autoGenerate = true)
    val idAgenda: Long = 0,

    @ColumnInfo(name = "especialidadeAgenda")
    val especialidadeAgenda: String,

    @ColumnInfo(name = "dataAgenda")
    val dataAgenda: Date,

    @ColumnInfo(name = "horaAgenda")
    val horaAgenda: LocalTime,

    @ColumnInfo(name = "localAgenda")
    val localAgenda: String,

    @ColumnInfo(name = "procedimentoAgenda")
    val procedimentoAgenda: String,
) : Serializable
package com.example.projetovital.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "tblAlergia")
data class AlergiaEntity(
    @ColumnInfo(name = "idAlergia")
    @PrimaryKey(autoGenerate = true)
    val idAlergia: Long = 0,

    @ColumnInfo(name = "nomeAlergia")
    val nomeAlergia: String,
) : Serializable


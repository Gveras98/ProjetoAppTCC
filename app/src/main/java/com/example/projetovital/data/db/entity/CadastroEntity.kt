package com.example.projetovital.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tblCadastro")
data class CadastroEntity(
    @ColumnInfo(name = "idUser")
    @PrimaryKey(autoGenerate = true)
    val idUser: Long = 0,

    @ColumnInfo(name = "nomeUser")
    val nomeUser: String,

    @ColumnInfo(name = "sexoUser")
    val sexoUser: Char,

    @ColumnInfo(name = "dataNascimentoUser")
    val dataNascimentoUser: Date,

    @ColumnInfo(name = "cpfUser")
    val cpfUser: String,

    @ColumnInfo(name = "enderecoUser")
    val enderecoUser: String,

    @ColumnInfo(name = "cepUser")
    val cepUsuarioUser: String,

    @ColumnInfo(name = "telefoneUser")
    val telefoneUser: String,

    @ColumnInfo(name = "emailUser")
    val emailUser: String,

    @ColumnInfo(name = "numSusUser")
    val numSusUser: String,

    @ColumnInfo(name = "planoSaudeUser")
    val planoSaudeUser: String,

    @ColumnInfo(name = "numPlanoSaudeUser")
    val numPlanoSaudeUser: String,

    @ColumnInfo(name = "tipoSanguineoUser")
    val tipoSanguineoUser: String
)
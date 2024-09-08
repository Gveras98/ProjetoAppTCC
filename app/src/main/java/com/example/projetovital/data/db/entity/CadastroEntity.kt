package com.example.projetovital.data.db.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tblCadastro")
data class CadastroEntity (
    @PrimaryKey(autoGenerate = true)
    val idUser: Long = 0,
    val nomeUser: String,
    val sexoUser: Char,
    val dataNascimentoUser: Date,
    val cpfUser: String,
    val enderecoUser: String,
    val cepUsuarioUser: String,
    val telefoneUser: String,
    val emailUser: String,
    val numSusUser: String,
    val planoSaudeUser: String,
    val numPlanoSaudeUser: String,
    val tipoSanguineoUser: String
)
package com.example.projetovital.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.projetovital.data.db.dao.AgendaDao
import com.example.projetovital.data.db.dao.AlergiaDao
import com.example.projetovital.data.db.dao.CadastroDao
import com.example.projetovital.data.db.dao.ExamesDao
import com.example.projetovital.data.db.dao.MedicamentoDao
import com.example.projetovital.data.db.entity.AgendaEntity
import com.example.projetovital.data.db.entity.AlergiaEntity
import com.example.projetovital.data.db.entity.CadastroEntity
import com.example.projetovital.data.db.entity.ExamesEntity
import com.example.projetovital.data.db.entity.MedicamentoEntity

@Database(entities = [
    AgendaEntity::class,
    AlergiaEntity::class,
    CadastroEntity::class,
    ExamesEntity::class,
    MedicamentoEntity::class,],
    version = 1,
    exportSchema = false)

@TypeConverters(DateConverter::class)

abstract class AppDatabase : RoomDatabase() {

    abstract fun cadastroDao(): CadastroDao
    abstract fun agendaDao(): AgendaDao
    abstract fun examesDao(): ExamesDao
    abstract fun medicamentoDao(): MedicamentoDao
    abstract fun alergiaDao(): AlergiaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,  // Usa o contexto da aplicação para evitar vazamentos
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}


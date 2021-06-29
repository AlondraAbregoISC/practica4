 package com.example.mipractica4.io.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mipractica4.io.dao.ContactosDao
import com.example.mipractica4.io.entities.Contactos

@Database(entities = [Contactos::class], version = 1, exportSchema = false)
abstract class DBRoom : RoomDatabase() {

    abstract fun contactoDao(): ContactosDao?

    companion object {

        private var INSTANCE: DBRoom? = null

        fun getRoomDatabase(context: Context): DBRoom? {

            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    DBRoom::class.java, "Practica.db"
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE
        }

         fun destroyInstance(){

             INSTANCE = null
         }
    }
}
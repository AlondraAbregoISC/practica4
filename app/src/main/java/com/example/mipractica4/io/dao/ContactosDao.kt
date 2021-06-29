package com.example.mipractica4.io.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mipractica4.io.entities.Contactos

@Dao
interface ContactosDao {

    //Todo Create
    /**
     * alta de contactos
     */

    @Insert
    fun insertContact(vararg contacto: Contactos?)


    // Todo Read
    //obtenemos una lista de tipo contactos
    @Query ("SELECT * FROM Contactos")
    fun getAllContacts(): List<Contactos?>?

    //Todo update
    @Query("UPDATE CONTACTOS set NOMBRE = :nombre, AP_PATERNO = :apPaterno, AP_MATERNO = :apMaterno WHERE TELEFONO = :phone")
    fun updateContact(nombre: String, apPaterno: String, apMaterno:String, phone:String)

    //Delete
    @Query("DELETE FROM CONTACTOS WHERE TELEFONO = :tel")// Query delete
    fun deleteContact( vararg tel: String)

}
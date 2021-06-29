package com.example.mipractica4.io.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Contactos")
class Contactos : Serializable{

    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id = 0

    @ColumnInfo(name = "NOMBRE")
    var nombre : String? = null

    @ColumnInfo(name = "AP_PATERNO")
    var aPaterno : String? = null

    @ColumnInfo(name = "AP_MATERNO")
    var aMaterno: String? = null

    @ColumnInfo(name = "TELEFONO")
    var phone : String? = null

}
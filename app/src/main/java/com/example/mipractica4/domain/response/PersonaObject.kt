package com.example.mipractica4.domain.response

import java.io.Serializable

class PersonaObject : Serializable {

    var nombre: String? = null
    var edad: String? = null
    var ubicacionNombre: String? = null
    var imagePersona: Int = 0
    var lat: Double? = null
    var long: Double? = null


    constructor( image: Int, ubicacion: String, edad: String, nombre: String, lat: Double, long: Double) {
        this.lat = lat
        this.long = long
        this.imagePersona = image
        this.ubicacionNombre = ubicacion
        this.edad = edad
        this.nombre = nombre
    }
}







package com.example.mipractica4.io.entities

import java.io.Serializable

class Negocio: Serializable {

    // BottomSheet 1
    var nombre: String? = null
    var direccion: ZMRDireccion? = null
    var id: Int = 0
    var tipoNegocio: Int =  0
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    var numeroCelular: String? = null
    var email: String? = null
    var descripcion : String? = null

    //BottomSheetComplete 2

    var idOffer: Int = 0 // 0 == Productos || 1 == Servicios
    var categoria: ZMRCategoria? = null
    var tipoHorario: Int = 0 // 0 es ==24/7  || 1 == horario personalizado
    var listHorario: ArrayList<ZMRHorario>? = null

}
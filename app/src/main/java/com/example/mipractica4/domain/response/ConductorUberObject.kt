package com.example.mipractica4.domain.response

/**
 * clase de tipo pojo para los conductores de uber de nuestro mapa
 */
class ConductorUberObject constructor(var nombreConductor: String? = null,
                                            var lat: Double = 0.0,
                                            var lng: Double = 0.0,
                                            var idCamioneta: Int = 0,
                                            var numPlaca: String? = null,
                                            var calificacion: Double = 0.0){
}
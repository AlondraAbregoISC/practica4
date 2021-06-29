package com.example.mipractica4.domain.response

import java.io.Serializable

/**
 * Es nuestro objeto con los parametros para lista de spotify
 */

class SpotifyObject : Serializable {

    var cancion: String? = null
    var interprete: String? = null
    var imagenAlbum : Int = 0


    constructor()

    constructor(imagen : Int, interprete: String, cancion: String){
        this.imagenAlbum = imagen
        this.interprete = interprete
        this.cancion = cancion
    }

}
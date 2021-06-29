package com.example.mipractica4.ui.base.interfaces


/**
 * Clase permite escuchar los click de nuestro adapter y sirve como un puente que notifique a la vista
 */
interface OnAdapterClickListener<T> {


    fun onClickItem(item: T, position: Int)// Funcion generica donde solicitamos el objeto y la posicion de la lista

    fun onClickEliminar(item: T, position: Int)
}




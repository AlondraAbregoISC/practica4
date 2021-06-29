package com.example.mipractica4.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mipractica4.ui.base.interfaces.OnAdapterClickListener

abstract class BaseAdapter<T>(val mListener: OnAdapterClickListener<T>): RecyclerView.Adapter<BaseViewHolder<T>>() {

    protected var mItems: MutableList<T> =ArrayList()
    /**
     * funcion para actualizar datos del adaptador
     */
    fun updateData(listaMutable: MutableList<T>?){

        if ( listaMutable != null){
            mItems.clear()// Borrador de datos de la lista
            mItems.addAll(listaMutable)//agregamos los nuevos datos proporcionados
            notifyDataSetChanged()
        }
    }
    /**
     * funcion generica para inflar el lienzo que usen nuestros item
     */
    protected open fun getViewFromLayout(viewGroup: ViewGroup, layout: Int): View? {
        return LayoutInflater.from(viewGroup.context).inflate(layout, viewGroup, false)
    }
    /**
     * funcion sobre escrita que permite retornar el total de elementos que contiene nuestra lista mutable
     */
    override fun getItemCount(): Int {
        return mItems.size
    }
    /**
     * Funcion generica que sirve para obtener la lista Mutable
     */
    fun getItems() = mItems
}
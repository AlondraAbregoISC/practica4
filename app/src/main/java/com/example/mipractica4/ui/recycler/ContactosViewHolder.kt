package com.example.mipractica4.ui.recycler

import android.view.View
import com.example.mipractica4.io.entities.Contactos
import com.example.mipractica4.ui.base.BaseViewHolder
import com.example.mipractica4.ui.base.interfaces.OnAdapterClickListener
import kotlinx.android.synthetic.main.item_contactos.view.*


class ContactosViewHolder (itemView: View): BaseViewHolder<Contactos>(itemView) {
    /**
     * Seteamos los datos proporcionados por el adapter
     */

    override fun fillViewHolder() {

        // comenzamos a setear los datos
        itemView.tvContacto.text = "${item!!.nombre} ${item!!.aPaterno} ${item!!.aMaterno}"
        itemView.tvPhone.text = item!!.phone

        // IMplementamos el click en nuestro adaptador
        itemView.ivEdit.setOnClickListener{
            mListener!!.onClickItem(item!!, mPosition)
        }

        itemView.ivDelete.setOnClickListener{
            mListener!!.onClickEliminar(item!!, mPosition)
        }
    }
}
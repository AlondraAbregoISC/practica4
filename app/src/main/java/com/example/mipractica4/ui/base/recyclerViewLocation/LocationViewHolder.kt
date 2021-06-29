package com.example.mipractica4.ui.base.recyclerViewLocation

import android.view.View
import androidx.core.content.ContextCompat
import com.example.mipractica4.domain.response.PersonaObject
import com.example.mipractica4.ui.base.BaseViewHolder
import com.example.mipractica4.ui.base.interfaces.OnAdapterClickListener
import kotlinx.android.synthetic.main.item_spotify.view.*
import kotlinx.android.synthetic.main.item_ubicacion.view.*
import kotlinx.android.synthetic.main.item_ubicacion.view.clPrincipal


class LocationViewHolder (itemView: View): BaseViewHolder<PersonaObject>(itemView){

    override fun fillViewHolder() {
        itemView.tvNombre.text = item!!.nombre
        itemView.tvEdad.text = item!!.edad
        itemView.tvUbicacion.text = item!!.ubicacionNombre
        itemView.ivPersona.background = ContextCompat.getDrawable(mContext, item!!.imagePersona)
        itemView.clPrincipal.setOnClickListener {
           mListener!!.onClickItem(item!!, mPosition)
        }
    }

}






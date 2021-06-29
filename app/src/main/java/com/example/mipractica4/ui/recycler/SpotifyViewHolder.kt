package com.example.mipractica4.ui.recycler

import android.view.View
import androidx.core.content.ContextCompat
import com.example.mipractica4.domain.response.SpotifyObject
import com.example.mipractica4.ui.base.BaseViewHolder
import com.example.mipractica4.ui.base.interfaces.OnAdapterClickListener
import kotlinx.android.synthetic.main.item_spotify.view.*


/**
 *clase de tipo viewHolder necesaria para nuestro adaptador de el recyclerView
 */
class SpotifyViewHolder(itemView: View): BaseViewHolder<SpotifyObject>(itemView) {

    /**
     * Seteamos los datos proporcionados por el adapter
     */
    override fun fillViewHolder() {
        itemView.tvCancion.text = item!!.cancion
        itemView.tvInterprete.text = item!!.interprete
        itemView.ivSpotify.background = ContextCompat.getDrawable(mContext, item!!.imagenAlbum)
        itemView.clPrincipal.setOnClickListener {
           mListener!!.onClickItem(item!!, mPosition)
        }
    }

}



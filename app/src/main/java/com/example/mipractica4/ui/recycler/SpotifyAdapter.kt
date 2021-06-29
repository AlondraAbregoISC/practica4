package com.example.mipractica4.ui.recycler

import android.view.ViewGroup
import com.example.mipractica4.R
import com.example.mipractica4.domain.response.SpotifyObject
import com.example.mipractica4.ui.base.BaseAdapter
import com.example.mipractica4.ui.base.BaseViewHolder
import com.example.mipractica4.ui.base.interfaces.OnAdapterClickListener

/**
     * paso numero 1._clase de tipo recycler view,adapter es un adaptador que usaremos para la lista  tipo spotify
     *
     * 2.- Crear lienzo
     *
     */
class SpotifyAdapter(mLister: OnAdapterClickListener<SpotifyObject>) : BaseAdapter<SpotifyObject>(mLister) {

    override fun onBindViewHolder(holder: BaseViewHolder<SpotifyObject>, position: Int) {
        val item  = mItems[position]
        holder.onBindItem(mItems, mListener, item, position)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<SpotifyObject> {
        val view = getViewFromLayout(p0, R.layout.item_spotify)
        return SpotifyViewHolder(view!!)// Retornamos nuestro ViewHolder
    }

}
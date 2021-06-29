package com.example.mipractica4.ui.recycler

import android.view.ViewGroup
import com.example.mipractica4.R
import com.example.mipractica4.io.entities.Contactos
import com.example.mipractica4.ui.base.BaseAdapter
import com.example.mipractica4.ui.base.BaseViewHolder
import com.example.mipractica4.ui.base.interfaces.OnAdapterClickListener

class ContactosAdapter (mLister: OnAdapterClickListener<Contactos>) : BaseAdapter<Contactos>(mLister) {

    override fun onBindViewHolder(holder: BaseViewHolder<Contactos>, position: Int) {
        val item  = mItems[position]
        holder.onBindItem(mItems, mListener, item, position)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<Contactos> {
        val view = getViewFromLayout(p0, R.layout.item_contactos)
        return ContactosViewHolder(view!!)// Retornamos nuestro ViewHolder
    }
}
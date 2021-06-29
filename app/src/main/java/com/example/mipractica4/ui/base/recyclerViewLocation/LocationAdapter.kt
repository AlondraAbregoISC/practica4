package com.example.mipractica4.ui.base.recyclerViewLocation

import android.view.ViewGroup
import com.example.mipractica4.R
import com.example.mipractica4.domain.response.PersonaObject
import com.example.mipractica4.ui.base.BaseAdapter
import com.example.mipractica4.ui.base.BaseViewHolder
import com.example.mipractica4.ui.base.interfaces.OnAdapterClickListener


class LocationAdapter (miLister: OnAdapterClickListener<PersonaObject>) : BaseAdapter<PersonaObject>(miLister) {

    override fun onBindViewHolder(holder: BaseViewHolder<PersonaObject>, position: Int) {
        val objeto  = mItems[position]
        holder.onBindItem(mItems, mListener, objeto, position)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<PersonaObject> {
        val view = getViewFromLayout(p0, R.layout.item_ubicacion)
        return LocationViewHolder(view!!)
    }

}
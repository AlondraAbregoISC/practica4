package com.example.mipractica4.ui.view.informacionCancion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.mipractica4.R
import com.example.mipractica4.domain.response.SpotifyObject

class DetalleCancionFragment : Fragment() {

    companion object {

        val TAG = DetalleCancionFragment::class.java.simpleName

        fun getInstance(bundle: Bundle?): DetalleCancionFragment? {
            val detalleCancionFragment = DetalleCancionFragment()
            if (bundle != null) {
                detalleCancionFragment.arguments = bundle
            }
            return detalleCancionFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val infoCancion : SpotifyObject= arguments?.getSerializable(TAG) as SpotifyObject

        val nombreCancion = view.findViewById<TextView>(R.id.tv_cancion_portada)
        nombreCancion.text= infoCancion.cancion

        val inteprete = view.findViewById<TextView>(R.id.tv_interprete_portada)
        inteprete.text = infoCancion.interprete

        val image = view.findViewById<ImageView>(R.id.im_portada)
        image.background = context?.let { ContextCompat.getDrawable(it, infoCancion.imagenAlbum) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detalle_cancion, container, false)

    }
}

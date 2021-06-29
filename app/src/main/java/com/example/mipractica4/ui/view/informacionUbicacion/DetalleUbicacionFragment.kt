package com.example.mipractica4.ui.view.informacionUbicacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mipractica4.R
import com.example.mipractica4.domain.response.PersonaObject
import com.example.practica4.ui.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class DetalleUbicacionFragment : BaseFragment(), OnMapReadyCallback {

    private lateinit var infoPersona : PersonaObject

    companion object {

        val TAG = DetalleUbicacionFragment::class.java.simpleName

        fun getInstance(bundle: Bundle?): DetalleUbicacionFragment? {
            val detalleUbicacionFragment = DetalleUbicacionFragment()
            if (bundle != null) {
                detalleUbicacionFragment.arguments = bundle
            }
            return detalleUbicacionFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detalle_ubicacion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        infoPersona = arguments?.getSerializable(TAG) as PersonaObject
        val mapa = childFragmentManager.findFragmentById(R.id.map2) as SupportMapFragment
        mapa.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
        val ubicacion = LatLng(infoPersona.lat!!, infoPersona.long!!)
        val camara = CameraPosition.builder().target(ubicacion).zoom(15f).build()
        p0?.moveCamera(CameraUpdateFactory.newCameraPosition(camara))
        p0?.addMarker( MarkerOptions().position(ubicacion).title("Ubicacion Actual"))
    }
}
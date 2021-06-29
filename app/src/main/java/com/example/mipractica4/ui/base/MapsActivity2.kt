package com.example.mipractica4.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mipractica4.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity2 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    lateinit var fusedLocationClient: FusedLocationProviderClient
    var latitude = 0.0
    var longitude = 0.0
    lateinit var mapFragment: SupportMapFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps2)

        mapFragment = supportFragmentManager.findFragmentById(R.id.map2) as SupportMapFragment

    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        if (latitude != 0.0 && longitude != 0.0) {
            val miUbicacion = LatLng(latitude, longitude)

            val cameraPosition = CameraPosition.builder()
                .target(miUbicacion)
                .zoom(15f)
                .build()

            mMap.addMarker(MarkerOptions().position(miUbicacion).title("Mi ubicacion"))
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

            mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        }
    }
}
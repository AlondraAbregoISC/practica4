package com.example.mipractica4.ui.base

import android.annotation.SuppressLint
import android.content.Context
import android.location.Criteria
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mipractica4.R
import com.example.mipractica4.domain.response.ConductorUberObject
import com.example.mipractica4.utils.EnumCamionetas
import com.example.mipractica4.utils.Utils
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*

/**
 *1 Crear API KEY en la consola de google
*2 Modificamos el XML
*3 Validar que este validado en el manifets el permiso de ubicacion
*4 Agregar al gradle la libreria de google
 */

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    lateinit var fusedLocationClient: FusedLocationProviderClient //importante agregar dependencia
    var latitude = 0.0
    var longitude = 0.0
    lateinit var mapFragment: SupportMapFragment
    lateinit var btnShowVans: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment //Casteamos el fragment del xml con el mapa
        
        getLocation()
    }
    /**
     * Cuando nuesto mapa esta listo
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        if(latitude != 0.0 && longitude != 0.0) {
            val miUbicacion = LatLng(latitude, longitude)

            val cameraPosition = CameraPosition.builder()
                .target(miUbicacion)
                .zoom(15f)
                .build()

            mMap.addMarker(MarkerOptions().position(miUbicacion).title("Mi ubicacion"))
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

            // Definir tipo de mapa

            mMap.mapType = GoogleMap.MAP_TYPE_HYBRID

            // InitUi()

            initUI()
        }
    }
    @SuppressLint("MissingPermission")
    fun getLocation() {

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->

            if (location == null) {
                try {

                    val service = getSystemService(Context.LOCATION_SERVICE) as LocationManager
                    val criteria = Criteria()// Una clase que indica los criterios de aplicación para seleccionar un proveedor de ubicación. Los proveedores pueden ordenarse de acuerdo con la precisión, el uso de energía, la capacidad de informar la altitud, la velocidad, el rumbo y el costo monetario.
                    val provider = service.getBestProvider(criteria, false)//proveedor de ubicacion
                    val locationProvider: Location = service.getLastKnownLocation(provider!!)!!//Solicita al proveedor de ubicacion la ultima ubicacion conocida

                    if (locationProvider == null) {

                        getLocation()
                        return@addOnSuccessListener

                    } else {

                        latitude = locationProvider.latitude
                        longitude = locationProvider.longitude
                        mapFragment.getMapAsync(this)
                    }
                } catch (e: Exception) {
                    Log.d(javaClass.simpleName, " Exception ${e.cause} ${e.localizedMessage}")
                }
            } else {

                latitude = location.latitude
                longitude = location.longitude
                mapFragment.getMapAsync(this)
            }
        }
    }

    fun initUI(){

        btnShowVans = findViewById(R.id.btnCamionetas)// casteo del widget

        btnShowVans.setOnClickListener{

            starMultipleMarkers()
        }

        radio_group?.setOnCheckedChangeListener { radioGroup, idRadioButton ->
            val isChecked: Boolean = radioGroup.findViewById<RadioButton>(idRadioButton).isChecked

            if (isChecked) {

                val tipoOpcion = when (idRadioButton) {

                    R.id.btnTerreno -> GoogleMap.MAP_TYPE_TERRAIN

                    R.id.btnHibrido -> GoogleMap.MAP_TYPE_HYBRID

                    R.id.btnNormal -> GoogleMap.MAP_TYPE_NORMAL

                    R.id.btnSatelite -> GoogleMap.MAP_TYPE_SATELLITE

                    R.id.btnNinguno -> GoogleMap.MAP_TYPE_NONE

                    else -> GoogleMap.MAP_TYPE_NORMAL

                }
                mMap.mapType = tipoOpcion
            }
        }
    }
    /**
     * implementamos varios marcadores dentro del mapa
     */

    fun starMultipleMarkers(){

        var list = Utils.getUberList()

        if(mMap != null){

            for(item: ConductorUberObject in list){

                var enumCamioneta = EnumCamionetas.getFromId(item.idCamioneta)// Enum inicializado

                //agregamos el marcador al mapa

                mMap.addMarker(MarkerOptions().position(LatLng(item.lat, item.lng))
                    .icon(Utils.bitamDescriptor(this, EnumCamionetas.getRecurso(enumCamioneta)))
                    .title("Conductor: ${item.nombreConductor}, Cal: ${item.calificacion.toString()}")
                )
            }

        }else{
            Toast.makeText(this, "Algo fallo al inicializar el mapa", Toast.LENGTH_SHORT).show()
        }
    }
}
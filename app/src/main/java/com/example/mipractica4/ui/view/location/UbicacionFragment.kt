package com.example.mipractica4.ui.view.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mipractica4.R
import com.example.mipractica4.domain.response.PersonaObject
import com.example.mipractica4.ui.base.interfaces.OnAdapterClickListener
import com.example.mipractica4.ui.base.recyclerViewLocation.LocationAdapter
import com.example.mipractica4.ui.view.informacionUbicacion.DetalleUbicacionFragment
import com.example.mipractica4.ui.view.recyclerView.RecyclerViewFragment
import com.example.practica4.ui.base.BaseFragment

class UbicacionFragment : BaseFragment(), OnAdapterClickListener<PersonaObject> {

    private var rootView: View? = null
    private var adapter: LocationAdapter? = null
    private lateinit var rvUbicacion: RecyclerView

    companion object {

        val TAG = UbicacionFragment::class.java.simpleName

        fun getInstance(bundle: Bundle?): UbicacionFragment? {
            val ubicacionFragment = UbicacionFragment()
            if (bundle != null) {
                ubicacionFragment.arguments = bundle
            }
            return ubicacionFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_ubicacion,container,false)
        initUI()
        return  rootView
    }
    fun initUI(){

        rvUbicacion = rootView!!.findViewById(R.id.rvUbicacion)
        adapter = LocationAdapter(this)

        rvUbicacion.layoutManager = LinearLayoutManager(requireContext())
        rvUbicacion.setHasFixedSize(true)
        rvUbicacion.adapter = adapter

        adapter!!.updateData(returnList())
    }
    private fun returnList(): ArrayList<PersonaObject>{

        var lista = ArrayList<PersonaObject>()

        var person =PersonaObject(R.drawable.alo,"Sonora", "24 años", "Alondra Abrego", 29.043679500997047, -110.97323918979978)
        lista.add(person)
        var person2 =PersonaObject(R.drawable.carlos,"Veracruz", "22 años", "Carlos Antonio", 18.85826538755488, -97.09820537759607)
        lista.add(person2)
        var person3 =PersonaObject(R.drawable.jcarlos,"Monterrey", "26 años", "Carlos Lopez", 25.658400970968042, -100.23726073322655)
        lista.add(person3)
        var person4 =PersonaObject(R.drawable.jesus,"Chiapas", "28 años", "Jesus Romero", 16.325457729912188, -91.793154191143)
        lista.add(person4)
        var person5 =PersonaObject(R.drawable.jonathan,"Chihuahua", "25 años", "Jonathan de la Cruz", 28.65218103345956, -106.09072813458482)
        lista.add(person5)
        var person6 =PersonaObject(R.drawable.mujer1,"Sinaloa", "21 años", "Liliana Lerdo", 23.24050755818218, -106.41092967781194)
        lista.add(person6)
        var person7 =PersonaObject(R.drawable.victor,"Puebla", "29 años","Victor Lopez", 18.996297096418353, -98.23567402177224)
        lista.add(person7)
        var person8 =PersonaObject(R.drawable.miguel,"CDMX", "27 años", "Miguel Lechuga", 19.33217449132236, -99.08324154689782)
        lista.add(person8)
        var person9 =PersonaObject(R.drawable.joven,"Guadalajara", "23 años", "Amanda Gabriela", 20.67692691063019, -103.31689200453614)
        lista.add(person9)
        return lista
    }

    override fun onClickItem(item: PersonaObject, position: Int) {
        val bundle = Bundle()
        bundle.putSerializable(DetalleUbicacionFragment.TAG, item)
        val fragment = DetalleUbicacionFragment.getInstance(bundle)
        val  ft = fragmentManager?.beginTransaction()
         ft?.replace(R.id.frameLayout, fragment!!)
        ft?.addToBackStack(null)
        ft?.commitAllowingStateLoss()
    }

    override fun onClickEliminar(item: PersonaObject, position: Int) {
        TODO("Not yet implemented")
    }
}
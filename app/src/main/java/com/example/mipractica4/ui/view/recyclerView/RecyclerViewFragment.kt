package com.example.mipractica4.ui.view.recyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mipractica4.R
import com.example.mipractica4.domain.response.SpotifyObject
import com.example.mipractica4.ui.base.interfaces.OnAdapterClickListener
import com.example.mipractica4.ui.recycler.SpotifyAdapter
import com.example.mipractica4.ui.view.informacionCancion.DetalleCancionFragment
import com.example.practica4.ui.base.BaseFragment

class RecyclerViewFragment : BaseFragment(), OnAdapterClickListener<SpotifyObject>{

    private var rootView: View? = null
    private var adapter: SpotifyAdapter? = null
    private lateinit var rvSpotify: RecyclerView
    var indicador = "RECYCLER"

    companion object {

        val TAG = RecyclerViewFragment::class.java.simpleName

        fun getInstance(bundle: Bundle?): RecyclerViewFragment? {
            val recyclerViewFragment = RecyclerViewFragment()
            if (bundle != null) {
                recyclerViewFragment.arguments = bundle
            }
            return recyclerViewFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_recycler_view,container,false)
        initUI()
        return  rootView

    }
    fun initUI(){

        rvSpotify = rootView!!.findViewById(R.id.rvSpotify)//casteamos el
        adapter = SpotifyAdapter(this)

        rvSpotify.layoutManager = LinearLayoutManager(requireContext())// le pasamos su lineraLayoutManagger
        rvSpotify.setHasFixedSize(true)
        rvSpotify.adapter = adapter

        adapter!!.updateData(returnList())
    }
    /**
     * retorna lista
     */

    private fun returnList(): ArrayList<SpotifyObject>{

        var lista = ArrayList<SpotifyObject>()

        var heroes = SpotifyObject(R.drawable.heroes_silencio, "Heroes del Silencio", "Maldito Duende")
        lista.add(heroes)

        var sia = SpotifyObject(R.drawable.sia_thunder, "Sia", "ThunderClouds")
        lista.add(sia)

        var blink = SpotifyObject(R.drawable.blink182, "BLink 182", "I Miss You")
        lista.add(blink)

        var tones = SpotifyObject(R.drawable.dance_monkey, "Tones and I", "Dance Monkey")
        lista.add(tones)

        var selena = SpotifyObject(R.drawable.selena_gomez, "Selena Gomez ", "The heart wants what it wants")
        lista.add(selena)

        var avril = SpotifyObject(R.drawable.avril_lavigne, "Avril Lavigne", "I give you what you like")
        lista.add(avril)

        var lana = SpotifyObject(R.drawable.lana_del_rey, "Lana del Rey", "Summertime sadness")
        lista.add(lana)

        var harry = SpotifyObject(R.drawable.harry, "Harry Styles", "Adore you")
        lista.add(harry)

        var taylor = SpotifyObject(R.drawable.taylor, "Taylor Swift", "Style")
        lista.add(taylor)

        var matisse = SpotifyObject(R.drawable.matisse, "Matisse", "Mas que amigos")
        lista.add(matisse)

        return lista
    }

    // Escuchamos el onclick
    override fun onClickItem(item: SpotifyObject, position: Int) {

        val bundle = Bundle()
        bundle.putSerializable(DetalleCancionFragment.TAG, item)

        val  ft = fragmentManager?.beginTransaction()
        DetalleCancionFragment.getInstance(bundle)?.let { ft?.replace(R.id.frameLayout, it) }
            ft?.addToBackStack(null)
        ft?.commitAllowingStateLoss()
    }

    override fun onClickEliminar(item: SpotifyObject, position: Int) {
        TODO("Not yet implemented")
    }
}
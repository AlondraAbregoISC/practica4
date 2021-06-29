package com.example.mipractica4.ui.view.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mipractica4.R
import com.example.mipractica4.io.db.DBRoom
import com.example.mipractica4.io.entities.Contactos
import com.example.mipractica4.ui.base.interfaces.OnAdapterClickListener
import com.example.mipractica4.ui.recycler.ContactosAdapter
import com.example.mipractica4.utils.Constants
import com.example.practica4.ui.base.BaseFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RoomFragment : BaseFragment(), OnAdapterClickListener<Contactos> {

    private lateinit var fabNewContact: FloatingActionButton
    private var rootView: View? = null
    private var room: DBRoom? = null
    private var adpt: ContactosAdapter? = null
    private lateinit var recycler: RecyclerView

    companion object {

        val TAG = RoomFragment::class.java.simpleName

        fun getInstance(bundle: Bundle?): RoomFragment {
            val fragmentRoom = RoomFragment()
            if (bundle != null) {
                fragmentRoom.arguments = bundle
            }
            return fragmentRoom
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_room, container, false)
        room = DBRoom.getRoomDatabase(requireContext())
        initUI()
        return rootView

    }

    private fun initUI() {
        fabNewContact = rootView!!.findViewById(R.id.fabNuevoContacto)
        recycler = rootView!!.findViewById(R.id.rvContactos)
        room = DBRoom.getRoomDatabase(requireContext())


        adpt = ContactosAdapter(this)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.setHasFixedSize(true)
        recycler.adapter = adpt


        fabNewContact.setOnClickListener {

            val fragment = AltaContactosFragment.getInstance(null)
            val tag = AltaContactosFragment.TAG
            pushFragment(fragment!!, tag, true)
        }

    }

    /**
     * Escuchar el evento cuando retorna desde el flujo de la alta de contactos para hacer ;a consulta y actualizar la lista de contactos
     */
    override fun onResume() {
        super.onResume()

        getContacts()
    }

    /**
     * metodo para obtener los contactos
     */

    private fun getContacts() {

        var list: List<Contactos?>? = room!!.contactoDao()!!.getAllContacts()

        if (list!!.size > 0) {

            adpt!!.updateData(list as ArrayList<Contactos>)

        }
    }

    /**
     * Escuchamos el click de boton eliminar
     */
    override fun onClickItem(item: Contactos, position: Int) {

        var bundle = Bundle()
        bundle.putSerializable(Constants.ITEM, item)

        pushFragment(EditContactosFragment.getInstance(bundle)!!, EditContactosFragment.TAG, true)
    }

    /**
     * metodo para eliminar
     */
    override fun onClickEliminar(item: Contactos, position: Int) {
        if (item != null) {

            room!!.contactoDao()!!.deleteContact(item.phone!!)
            getContacts()
        }
    }


}
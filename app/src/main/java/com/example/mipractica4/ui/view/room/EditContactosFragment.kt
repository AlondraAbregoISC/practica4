package com.example.mipractica4.ui.view.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.mipractica4.R
import com.example.mipractica4.io.db.DBRoom
import com.example.mipractica4.io.entities.Contactos
import com.example.mipractica4.utils.Constants
import com.example.practica4.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_edit.*

class EditContactosFragment  : BaseFragment(){

    private var rootView: View? = null
    lateinit var btnSave: Button

    lateinit var etName: EditText
    lateinit var etPAterno: EditText
    lateinit var etMaterno: EditText
    lateinit var tvTitle: TextView
    private var telefono:String? =  null


    companion object{

        val TAG = EditContactosFragment::class.java.simpleName

        fun getInstance(bundle: Bundle?): EditContactosFragment?{
            val fragmentHome = EditContactosFragment()
            if(bundle != null){
                fragmentHome.arguments= bundle
            }
            return fragmentHome
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_edit,container,false)
        initUI()
        return  rootView

    }

    /**
     * Inicializa la interfaz de usuario
     */
    fun initUI(){


        etName = rootView!!.findViewById(R.id.etName)
        etPAterno = rootView!!.findViewById(R.id.etAPaterno)
        etMaterno = rootView!!.findViewById(R.id.etAMaterno)
        tvTitle = rootView!!.findViewById(R.id.tvTitle)

        btnSave = rootView!!.findViewById(R.id.btnGuardar)

        var bundle = arguments //FRagmentRoom proporciona el Bundle


        if(bundle != null){

            var item: Contactos = bundle.getSerializable(Constants.ITEM) as Contactos
            telefono = item.phone
            tvTitle.setText("Edita el teléfono: ${item.phone}")

        }

        btnSave.setOnClickListener {

            ediContact(etName.text.toString(), etAPaterno.text.toString(),etMaterno.text.toString(), telefono)

        }

    }

    /**
     * Método para almacenar el contacto en Room
     */
    fun ediContact(nombre: String?, apPaterno: String?, apMaterno: String?, phone:String?){

        if(nombre != null && apPaterno != null && apMaterno != null && phone != null){

            var room = DBRoom.getRoomDatabase(requireContext())//Variable compartida de Room


            room!!.contactoDao()!!.updateContact(nombre, apPaterno,apMaterno, phone)

            //Una Vez insertado el entity Limpiamos los campos
            etName.setText("")
            etPAterno.setText("")
            etMaterno.setText("")

            Toast.makeText(requireContext(), "Se inserto el contacto satisfactoriamente", Toast.LENGTH_LONG).show()
            showLog("ROOM", "Insert Success")

        }else{
            showLog("ROOM", "Algo falló")
        }

    }



}
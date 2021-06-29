package com.example.mipractica4.ui.view.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mipractica4.R
import com.example.mipractica4.io.db.DBRoom
import com.example.mipractica4.io.entities.Contactos
import com.example.practica4.ui.base.BaseFragment

class AltaContactosFragment : BaseFragment() {


    private var rootView: View? = null
    lateinit var etName: EditText
    lateinit var etPAterno: EditText
    lateinit var etMaterno: EditText
    lateinit var etPhone: EditText

    lateinit var btnSave: Button

    companion object{

        val TAG = AltaContactosFragment::class.java.simpleName

        fun getInstance(bundle: Bundle?): AltaContactosFragment?{
            val altaContactosFragment = AltaContactosFragment()
            if(bundle != null){
                altaContactosFragment.arguments= bundle
            }
            return altaContactosFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_alta,container,false)
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
        etPhone = rootView!!.findViewById(R.id.etPhone)
        btnSave = rootView!!.findViewById(R.id.btnGuardar)

        btnSave.setOnClickListener {

            saveContact(etName.text.toString(), etPAterno.text.toString(),etMaterno.text.toString(), etPhone.text.toString())
        }
    }
    /**
     * Método para almacenar el contacto en Room
     */
    fun saveContact( nombre: String?, apPaterno: String?, apMaterno: String?, phone:String?){

        if(nombre != null && apPaterno != null && apMaterno != null && phone != null){

            var room = DBRoom.getRoomDatabase(requireContext())//Variable compartida de Room
            var entity = Contactos() //Creamos un objeto de tipo entity(es necesario para Room)
            entity.nombre = nombre
            entity.aPaterno = apPaterno
            entity.aMaterno = apMaterno
            entity.phone = phone

            //TODO invocamos a room e insertamos el objeto por medio de Dao

            room!!.contactoDao()!!.insertContact(entity)

            //Una Vez insertado el entity Limpiamos los campos
            etName.setText("")
            etPAterno.setText("")
            etMaterno.setText("")
            etPhone.setText("")

            Toast.makeText(requireContext(), "se inserto el contacto satisfactoriamente", Toast.LENGTH_LONG).show()
            showLog("ROOM", "Insert Success")

        }else{
            showLog("ROOM", "Algo falló")
        }
    }
}
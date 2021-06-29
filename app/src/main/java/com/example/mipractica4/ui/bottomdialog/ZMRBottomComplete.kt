package com.example.mipractica4.ui.bottomdialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.example.mipractica4.R
import com.example.mipractica4.io.entities.Negocio
import com.example.mipractica4.ui.base.interfaces.OnAdapterClickListener
import com.example.mipractica4.ui.bottomdialogdos.ZMRBottomCompleteDos
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.zmr_bottom_complete.*

class ZMRBottomComplete: BottomSheetDialogFragment (), DialogInterface.OnShowListener, CompoundButton.OnCheckedChangeListener{

    var rootView: View? = null
    var negocio: Negocio? = null

    lateinit var listener: OnAdapterClickListener<Negocio>
    lateinit var chipPersonalizar: Chip
    lateinit var  chipServicio: Chip
    lateinit var  chipDisponible: Chip
    lateinit var chipPersonalizado: Chip

    lateinit var spinner: Spinner

    companion object{

        fun newInstance(item: Negocio?)=
            ZMRBottomComplete().apply {
                this.negocio = item
            }
    }

    /**
     * nos permite servir como un puente y referenciarlo desde donde se invoque el BottomSheet
     */
    fun onAdapterBottomClick(listener: OnAdapterClickListener<Negocio>){
        this.listener = listener
    }

    /**
     * dentro de onCreate seteamos el estilo de mi BottomSheet
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.z_bottom_sheet_style)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.zmr_bottom_complete,container,false)
        return  rootView
    }

    /**
     * necesario para el onShowListener
     */

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        return dialog
    }

    /**
     * Inicializamos la interfaz de usuario
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniUI()
    }

    private fun iniUI(){

        chipPersonalizar = rootView!!.findViewById(R.id.chipProductos)
        chipPersonalizar.isChecked = true // encendemos el chip inicialmente
        chipPersonalizar.setOnCheckedChangeListener(this)

        chipServicio = rootView!!.findViewById(R.id.chipServicios)
        chipServicio.setOnCheckedChangeListener(this)

        chipDisponible = rootView!!.findViewById(R.id.chipDisponible)
        chipDisponible.setOnCheckedChangeListener(this)

        chipPersonalizado = rootView!!.findViewById(R.id.chipPersonalizar)
        chipPersonalizado.setOnCheckedChangeListener(this)

        spinner = rootView!!.findViewById(R.id.spinner)

        var categoryList = ArrayList<String>()
        categoryList.add("Electronicos y linea blanca")
        categoryList.add("Belleza y cuidados de piel")
        categoryList.add("Computadoras")
        categoryList.add("Celulares")

        spinner.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, categoryList)
    }

    override fun onShow(p0: DialogInterface?) {

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {


        when(buttonView?.id){

            R.id.chipProductos->{

                if(isChecked){
                    chipServicio.isChecked = false
                    chipProductos.isChecked = true

                    negocio?.idOffer = 0

                }
            }

            R.id.chipServicios->{

                if(isChecked){
                    chipServicio.isChecked = true
                    chipProductos.isChecked = false

                    negocio?.idOffer = 1

                }
            }
            R.id.chipDisponible->{

                if(isChecked){
                    chipDisponible.isChecked = true
                    chipPersonalizado.isChecked = false

                    negocio?.tipoHorario = 0
                }
            }
            R.id.chipPersonalizar->{

                if(isChecked){
                    chipPersonalizado.isChecked = true
                    chipDisponible.isChecked = false

                    negocio?.tipoHorario = 1

                }
            }
        }
    }
}
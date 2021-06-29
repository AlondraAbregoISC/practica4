package com.example.mipractica4.ui.view.radioButton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.example.mipractica4.R
import com.example.mipractica4.constans.Contants.TAG_LOG
import com.example.practica4.ui.base.BaseFragment

class RadioButtonFragment: BaseFragment(), View.OnClickListener {

    private var rootView: View? = null
    private lateinit var rbRojo: RadioButton
    private lateinit var rbAzul: RadioButton
    private lateinit var rbVerde : RadioButton
    private lateinit var rbAmarillo: RadioButton
    private lateinit var rbRosa: RadioButton
    private lateinit var rbAnaranjado: RadioButton
    private lateinit var rbGris : RadioButton
    private lateinit var rbMorado: RadioButton
    private lateinit var rbVerdeClaro : RadioButton
    private lateinit var rbRosaFuerte: RadioButton
    private lateinit var rbCafe: RadioButton
    private lateinit var rbBlanco: RadioButton

    private lateinit var rlPrincipal : RelativeLayout


    companion object{

        val TAG = RadioButtonFragment::class.java.simpleName

        fun getInstance(bundle: Bundle?): RadioButtonFragment?{
            val fragment = RadioButtonFragment()
            if(bundle != null){
                fragment.arguments= bundle
            }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_radio_button,container,false)
        initUI()
        return  rootView
    }

    private fun initUI() {

        rbRojo = rootView!!.findViewById(R.id.rbRojo)
        rbAzul = rootView!!.findViewById(R.id.rbAzul)
        rbVerde = rootView!!.findViewById(R.id.rbVerde)
        rbAmarillo = rootView!!.findViewById(R.id.rbAmarillo)
        rbRosa = rootView!!.findViewById(R.id.rbRosa)
        rbAnaranjado= rootView!!.findViewById(R.id.rbAnaranjado)
        rbGris = rootView!!.findViewById(R.id.rbGris)
        rbMorado = rootView!!.findViewById(R.id.rbMorado)
        rbVerdeClaro = rootView!!.findViewById(R.id.rbVerde_claro)
        rbRosaFuerte = rootView!!.findViewById(R.id.rbRosa_fuerte)
        rbCafe = rootView!!.findViewById(R.id.rbCafe)
        rbBlanco = rootView!!.findViewById(R.id.rbBlanco)
        rlPrincipal = rootView!!.findViewById(R.id.rlPrincipal)

        rbRojo.setOnClickListener(this)
        rbAzul.setOnClickListener(this)
        rbVerde.setOnClickListener(this)
        rbAmarillo.setOnClickListener(this)
        rbRosa.setOnClickListener(this)
        rbAnaranjado.setOnClickListener(this)
        rbGris.setOnClickListener(this)
        rbMorado.setOnClickListener(this)
        rbVerdeClaro.setOnClickListener(this)
        rbRosaFuerte.setOnClickListener(this)
        rbCafe.setOnClickListener(this)
        rbBlanco.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.rbRojo -> {
                rlPrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.rojo))
                showLog(TAG_LOG, "Seleccionaste el color Rojo")

            }
            R.id.rbAzul -> {
                rlPrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.azul))
                showLog(TAG_LOG, "Seleccionaste el color Azul")
            }
            R.id.rbVerde -> {
                rlPrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.verde))
                showLog(TAG_LOG, "Seleccionaste el color Verde")
            }
            R.id.rbAmarillo -> {
                rlPrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.amarillo))
                showLog(TAG_LOG, "Seleccionaste el color Amarillo")

            }
            R.id.rbRosa ->{
                rlPrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.rosa))
                showLog(TAG_LOG , "Seleccionaste el color Rosa" )
            }
            R.id.rbAnaranjado ->{
                rlPrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.anaranjado))
                showLog(TAG_LOG , "Seleccionaste el color Anaranjado" )
            }
            R.id.rbGris ->{
                rlPrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.gris))
                showLog(TAG_LOG , "Seleccionaste el color Gris" )
            }
            R.id.rbMorado ->{
                rlPrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.morado))
                showLog(TAG_LOG , "Seleccionaste el color Morado" )
            }
            R.id.rbVerde_claro ->{
                rlPrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.verde_claro))
                showLog(TAG_LOG , "Seleccionaste el color Verde Claro" )
            }
            R.id.rbRosa_fuerte ->{
                rlPrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.rosa_fuerte))
                showLog(TAG_LOG , "Seleccionaste el color Rosa Fuerte" )
            }
            R.id.rbCafe->{
                rlPrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.cafe))
                showLog(TAG_LOG , "Seleccionaste el color Cafe" )
            }
            R.id.rbBlanco -> {
                rlPrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.blanco))
                showLog(TAG_LOG, "Seleccionaste el color Blanco")
            }
        }
    }
}
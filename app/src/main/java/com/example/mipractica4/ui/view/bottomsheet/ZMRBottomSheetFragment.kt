package com.example.mipractica4.ui.view.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.mipractica4.R
import com.example.mipractica4.io.entities.Negocio
import com.example.mipractica4.ui.bottomdialog.ZMRBottomComplete
import com.example.mipractica4.ui.bottomdialogdos.ZMRBottomCompleteDos

import com.example.practica4.ui.base.BaseFragment

class ZMRBottomSheetFragment : BaseFragment(){

    private var rootView: View? = null
    private lateinit var zmrBottom: Button
    private lateinit var zmrBottomS: Button
    private var bottomSheet: ZMRBottomComplete? = null
    private var bottomSheet2: ZMRBottomCompleteDos? = null


    companion object{

        val TAG = ZMRBottomSheetFragment::class.java.simpleName

        fun getInstance(bundle: Bundle?): ZMRBottomSheetFragment{
            val fragmentBottomSheet = ZMRBottomSheetFragment()
            if(bundle != null){
                fragmentBottomSheet.arguments= bundle
            }
            return fragmentBottomSheet
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.z_fragment_bottom,container,false)
        initIU()
        return  rootView
    }

    private fun initIU() {
        zmrBottom = rootView!!.findViewById(R.id.zmrButtonStart)
        zmrBottomS = rootView!!.findViewById(R.id.zmrButtonSheet)
        zmrBottom.setOnClickListener {
            startBottomSheet()
        }

        zmrBottomS.setOnClickListener {
            startBottomSheet2()
        }
    }

    private fun startBottomSheet() {

        if(bottomSheet == null || !bottomSheet?.isAdded!!){

            // TODO llenar el negocio
            bottomSheet = ZMRBottomComplete.newInstance(Negocio())

            bottomSheet?.show(requireActivity().supportFragmentManager, TAG)// Mostramos el bottomSheet
        }
    }

    private fun startBottomSheet2() {

        if(bottomSheet2 == null || !bottomSheet2?.isAdded!!){

            bottomSheet2 = ZMRBottomCompleteDos.newInstance(Negocio())

            bottomSheet2?.show(requireActivity().supportFragmentManager, TAG)
        }


    }

    }
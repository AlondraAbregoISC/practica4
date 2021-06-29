package com.example.mipractica4.ui.bottomdialogdos

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.example.mipractica4.R
import com.example.mipractica4.io.entities.Negocio
import com.example.mipractica4.ui.base.interfaces.OnAdapterClickListener
import com.example.mipractica4.ui.bottomdialog.ZMRBottomComplete
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip


class ZMRBottomCompleteDos: BottomSheetDialogFragment(), DialogInterface.OnShowListener, CompoundButton.OnCheckedChangeListener{

    var rootView: View? = null
    var negocio: Negocio? = null

    lateinit var listener: OnAdapterClickListener<Negocio>


    lateinit var spinnerDos: Spinner


    companion object{

        fun newInstance(item: Negocio?)=
            ZMRBottomCompleteDos().apply {
                this.negocio = item
            }
    }
    fun onAdapterBottomClick(listener: OnAdapterClickListener<Negocio>) {
        this.listener = listener

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.z_bottom_sheet_style)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.zmr_bottom_complete_dos,container,false)
        return  rootView
    }

    override fun onShow(dialog: DialogInterface?) {
        TODO("Not yet implemented")
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        TODO("Not yet implemented")
    }


}
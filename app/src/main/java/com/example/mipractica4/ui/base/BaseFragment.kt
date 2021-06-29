package com.example.practica4.ui.base

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.mipractica4.domain.response.PersonaObject
import com.example.mipractica4.ui.base.MainActivity

open class BaseFragment: Fragment() {


    fun showLog(tag: String, message: String) {
        Log.d(tag, message)
    }

    open fun onClickObjeto(objeto: PersonaObject, position: Int) {}

    fun pushFragment(fragment: Fragment, tag:String, backstack:Boolean) {

        if (activity != null) {
            val act: MainActivity = activity as MainActivity
            act.pushFragment(fragment, tag, backstack)
        }
    }
    }



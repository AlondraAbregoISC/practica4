package com.example.mipractica4.ui.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mipractica4.R

import com.example.practica4.ui.base.BaseFragment


class FragmentHome : BaseFragment(){

    private var rootView: View? = null

    companion object{

        val TAG = FragmentHome::class.java.simpleName

        fun getInstance(bundle: Bundle?): FragmentHome?{
            val fragmentHome = FragmentHome()
            if(bundle != null){
                fragmentHome.arguments= bundle
            }
            return fragmentHome
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_home,container,false)
        return  rootView
    }
}
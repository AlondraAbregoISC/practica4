package com.example.mipractica4.ui.view.helloWorld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mipractica4.R
import com.example.mipractica4.ui.view.lifeCycle.LifeCycle
import com.example.practica4.ui.base.BaseFragment


   class HelloWorld : BaseFragment() {

       companion object {

           val TAG = HelloWorld::class.java.simpleName

           fun getInstance(bundle: Bundle?): HelloWorld? {
               val helloWorld = HelloWorld()
               if (bundle != null) {
                   helloWorld.arguments = bundle
               }
               return helloWorld
           }
       }

       var rootView : View? = null

       override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
           rootView = inflater.inflate(R.layout.fragment_hola_mundo,container,false)
           return  rootView
       }

}

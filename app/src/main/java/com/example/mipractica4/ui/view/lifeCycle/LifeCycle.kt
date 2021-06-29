package com.example.mipractica4.ui.view.lifeCycle

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mipractica4.R
import com.example.practica4.ui.base.BaseFragment

class LifeCycle: BaseFragment() {

    private lateinit var tvCreate: TextView
    private lateinit var tvResume: TextView
    private lateinit var tvStar: TextView

    companion object {

        val TAG = LifeCycle::class.java.simpleName

        fun getInstance(bundle: Bundle?): LifeCycle? {
            val lifeCycle = LifeCycle()
            if (bundle != null) {
                lifeCycle.arguments = bundle
            }
            return lifeCycle
        }
    }

        var TAG : String = "life cycle"
        lateinit var btnFinish: Button
        var rootView : View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_life_cycle,container,false)
        tvCreate = rootView!!.findViewById(R.id.tvCreate)
        tvResume = rootView!!.findViewById(R.id.tvResume)
        tvStar = rootView!!.findViewById(R.id.tvStar)
        initUI()
        Log.d(TAG, getString(R.string.onCreateMessage))
        showToast(getString(R.string.onCreateMessage))

        tvCreate.text = "La activity a detonado el metodo onCreate"
        return  rootView
    }

        override fun onStart(){
            super.onStart()
            Log.d(TAG, getString(R.string.onStartMessage))
            showToast(getString(R.string.onStartMessage))
            tvStar.text = "onStart se esta ejecutando"
        }

        override fun onResume(){
            super.onResume()
            Log.d(TAG, getString(R.string.onResumeMessage))
            showToast(getString(R.string.onResumeMessage))
            tvResume.text = "El metodo onResume se esta ejecutando y la vista de nuestro Activity esta en primer plano"
        }
        //Todo la activity esta en segundo plano
        //onPause

        override fun onPause(){
            super.onPause()
            Log.d(TAG, getString(R.string.onPauseMessage))
            showToast(getString(R.string.onPauseMessage))

        }

        override fun onStop(){
            super.onStop()
            Log.d(TAG, getString(R.string.onStopMessage))
            showToast(getString(R.string.onStopMessage))

        }


        override fun onDestroy() {
            super.onDestroy()
            Log.d(TAG, getString(R.string.onDestroyMessage))
            showToast(getString(R.string.onDestroyMessage))
        }

        fun initUI() {
            btnFinish = rootView!!.findViewById(R.id.btnFinish)
            btnFinish.setOnClickListener {
                fragmentManager?.beginTransaction()?.remove(this)?.commit();


            }
        }

        fun showToast(mensaje: String){

            Toast.makeText( context, mensaje, Toast.LENGTH_LONG).show()
        }
}


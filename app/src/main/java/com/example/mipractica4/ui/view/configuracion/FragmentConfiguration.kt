package com.example.mipractica4.ui.view.configuracion

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.mipractica4.R
import com.example.mipractica4.constans.Contants.CAMARA_REQUEST
import com.example.mipractica4.constans.Contants.GALLERY_REQUEST
import com.example.mipractica4.constans.Contants.IMAGES
import com.example.mipractica4.ui.view.dialogs.DialogPreview
import com.example.mipractica4.utils.Utils
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException

/**
 * 1 Declaramos en nuestro manifest permisos
 * 2 Declaramos en manifest el permiso de camara
 * 3 declaramos el provider
 * 4 crear el archivo file_paths
 */

class FragmentConfiguration : Fragment() {

    private var rootView: View? = null
    private lateinit var btnCamara: Button
    private lateinit var btnGaleria: Button
    private var listener: FragmentConfigurationCallback? = null
    var mPhoto:String? = null

    companion object {

        val TAG = FragmentConfiguration::class.java.simpleName

        fun getInstance(bundle: Bundle?): FragmentConfiguration? {
            val fragment = FragmentConfiguration()
            if (bundle != null) {
                fragment.arguments = bundle
            }
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_configuration, container, false)
        initUI()
        return rootView
    }
    //inicializamos interfaz de usuario (se castean los widgets)
    private fun initUI() {

        btnCamara = rootView!!.findViewById(R.id.btnCamara)
        btnGaleria = rootView!!.findViewById(R.id.btnGaletia)

        btnGaleria.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(
                    arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    GALLERY_REQUEST
                )
            } else {
                //El usuario otorgo el permiso de almacenamiento
                initGallery()
            }
        }

        btnCamara.setOnClickListener {
            if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(android.Manifest.permission.CAMERA), CAMARA_REQUEST)
            } else {
                //Ya otorgo permisos
                initCamera()
            }
        }
    }

    private fun initCamera(){
        val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        //creamos el archivo
        var photo: File? = null
        try {
            photo = Utils.createImageFile(requireContext())
            mPhoto = photo!!.absolutePath
        }catch (ex: IOException) {
            Toast.makeText(requireContext(), "Error al cargar la imagen", Toast.LENGTH_SHORT).show()
        }
        if (photo != null){
            val photoUri = FileProvider.getUriForFile(requireContext(), requireContext().packageName, photo)

            intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)

            startActivityForResult(intentCamera, CAMARA_REQUEST)
        }
    }
    /**
     * logica para detonar el intent y acceder al almacenamiento del dispositivo
     */
    private fun initGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, GALLERY_REQUEST)
    }
    /**
     * Resultado de sobre escribir el metodo, aqui viene de regreso los datos seleccionados (GALLERY_REQUEST)
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {

            CAMARA_REQUEST -> {
                if (resultCode == Activity.RESULT_OK){
                    setPicture()
                }
            }

            GALLERY_REQUEST -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val bitmap = MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, data.data)
                    showDialog(bitmap)
                }
            }
        }
    }

    private fun setPicture(){
            val bitmapPhoto = BitmapFactory.decodeFile(mPhoto)
            val bitmapResize = Utils.getResizedBitmap(bitmapPhoto, 300, 300)//Aqui se reduce el peso de la imagen
            val bitmapRotado = Utils.rotateBitmap(bitmapResize!!, 360f)//se rota la imagen
        showDialog(bitmapRotado)
    }


    private fun showDialog(bitmapPhoto: Bitmap?) {
        val manager = fragmentManager
        val dg = DialogPreview()

        val stream = ByteArrayOutputStream()
        bitmapPhoto?.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val bitmapToByteArray = stream.toByteArray()

        val bundle = Bundle()
        bundle.putByteArray(IMAGES, bitmapToByteArray)
        dg.arguments = bundle
        dg.setStyle(DialogFragment.STYLE_NORMAL, R.style.dialogFragmentTheme)// TODO Importante esta linea para que no se vea recortado el dialogFRagment
        dg.show(manager!!, DialogPreview.TAG)

        dg.setListener(object : DialogPreview.DialogPreviewListener{// callback para escuchar cuando retorne la imagen recortada
            override fun sendToFragment(byteArray: ByteArray) {
                Log.d("SUCCESS", byteArray.toString())
                listener?.sendToActivity(byteArray)
                dg.dismiss()
            // activity!!.onBackPressed()// cerramos el fragmento
            }
        })
    }

    interface FragmentConfigurationCallback{
        fun sendToActivity(byteArray: ByteArray)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as FragmentConfigurationCallback// inicializamos el listener
    }
}

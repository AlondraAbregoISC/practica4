package com.example.mipractica4.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.os.Environment
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.example.mipractica4.domain.response.ConductorUberObject
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * clase de utilerias para no tener toodo en la clase principal
 */
class Utils {

    companion object {

        fun getUberList(): MutableList<ConductorUberObject> {

            var listUber: MutableList<ConductorUberObject> = ArrayList()

            var alondra = ConductorUberObject(
                " Alondra Abrego",
                18.84369783342475,
                -97.12679418975495,
                1,
                "XDGJHJ",
                6.6
            )
            listUber.add(alondra)

            var carlosA = ConductorUberObject(
                " Carlos Antonio",
                18.85826538755488,
                -97.09820537759607,
                2,
                "XDDFHJ",
                9.0
            )
            listUber.add(carlosA)

            var victor = ConductorUberObject(
                " Victor Lopez",
                18.797545039953008,
                -97.19150312268975,
                3,
                "XDGIOHJ",
                7.9
            )
            listUber.add(victor)

            var amanda = ConductorUberObject(
                " Amanda Gabriela ",
                18.840519742427148,
                -97.12914405615898,
                4,
                "XDGJZZ",
                8.0
            )
            listUber.add(amanda)

            var jesus = ConductorUberObject(
                " Jesus Romero",
                18.88246613866463,
                -96.93206691859034,
                2,
                "VCIAME",
                8.5
            )
            listUber.add(jesus)

            var jonathan = ConductorUberObject(
                "Jonathan de la Cruz ",
                18.818401104302627,
                -97.1641055618097,
                3,
                "LAJHDE",
                8.1
            )
            listUber.add(jonathan)

            var persona = ConductorUberObject(
                " Anahi Alfonso",
                61.88581793539245,
                25.842364171637602,
                1,
                "XDGJHJ",
                9.1
            )
            listUber.add(persona)

            var persona2 = ConductorUberObject(
                " Irving Vélez",
                46.88895812785116,
                7.57368913575545,
                2,
                "KMVDORO",
                9.0
            )
            listUber.add(persona2)

            var persona3 = ConductorUberObject(
                "Ashanti Maldonado",
                15.522987521866831,
                102.80253081035815,
                4,
                "MJSHURFR",
                7.9
            )
            listUber.add(persona3)

            var persona4 = ConductorUberObject(
                "Manuel Maldonado",
                -1.8164790616695787,
                -78.20371756108196,
                2,
                "NNASORO",
                8.0
            )
            listUber.add(persona4)

            var persona5 = ConductorUberObject(
                "Alejandra Rodríguez",
                44.5150691447043,
                102.76627921916761,
                1,
                "LAOERUC",
                8.5
            )
            listUber.add(persona5)

            var persona6 = ConductorUberObject(
                "Mariela Blanco",
                35.48186854523492,
                138.010420582146,
                4,
                "OISDNV",
                8.1
            )
            listUber.add(persona6)

            var persona7 = ConductorUberObject(
                "Cecilia Sánchez ",
                33.74598617511032,
                104.9635457661879,
                1,
                "LAPOPOE",
                6.6
            )
            listUber.add(persona7)

            var persona8 = ConductorUberObject(
                "Ingrid López",
                42.81823678579261,
                13.500277742620003,
                1,
                "LAOORIR",
                9.0
            )
            listUber.add(persona8)

            var persona9 = ConductorUberObject(
                "Alan Pineda",
                45.98805585390278,
                1.8987153072304515,
                3,
                "DSDROQW",
                9.0
            )
            listUber.add(persona9)

            var persona10 = ConductorUberObject(
                "Estela Suárez",
                53.29534085375965,
                -7.2327694122593025,
                4,
                "LAKIDSE",
                8.0
            )
            listUber.add(persona10)

            var persona11 = ConductorUberObject(
                "Antonio Juárez",
                52.60983733558063,
                18.66614516857369,
                2,
                "KADKJFDW",
                8.5
            )
            listUber.add(persona11)

            var persona12 = ConductorUberObject(
                "Andres Martínez",
                51.29639757115242,
                10.843879587136792,
                3,
                "IIWQOEW",
                8.1
            )
            listUber.add(persona12)

            var persona13 = ConductorUberObject(
                "Andrea Alducin",
                -6.784110951670308,
                -55.053192124200095,
                4,
                "DSIRJR",
                8.0
            )
            listUber.add(persona13)

            var persona14 = ConductorUberObject(
                "Miguel Lechuga",
                40.22896598287083,
                -4.936117644778678,
                2,
                "DDJSIR",
                8.5
            )
            listUber.add(persona14)

            var persona15 = ConductorUberObject(
                "Armando Lebrez",
                23.602519242148762,
                121.36388435032886,
                2,
                "CJMIRE",
                8.1
            )
            listUber.add(persona15)

            var persona16 = ConductorUberObject(
                "Karen Balderas",
                24.578357064821056,
                -102.12259839410439,
                1,
                "MVOREE",
                10.0
            )
            listUber.add(persona16)

            var persona17 = ConductorUberObject(
                "Jose Antonio",
                21.668923552222907,
                -98.6948640381938,
                2,
                "NCVXOO",
                9.0
            )
            listUber.add(persona17)

            var persona18 = ConductorUberObject(
                " Victoria Blanco",
                23.81676571661237,
                -104.27591869461226,
                4,
                "KJSDRI",
                7.9
            )
            listUber.add(persona18)

            var persona19 = ConductorUberObject(
                "Merida Moran ",
                28.005322462137865,
                -106.73685618090703,
                4,
                "KAJDHC",
                8.0
            )
            listUber.add(persona19)

            var persona20 = ConductorUberObject(
                " Juan Hernandez",
                27.538726195160685,
                -106.95658274218334,
                2,
                "JAJDIE",
                8.5
            )
            listUber.add(persona20)

            var persona21 = ConductorUberObject(
                "Josue Jimenez",
                28.701437334269965,
                -107.30814524022546,
                3,
                "KAKJDS",
                8.1
            )
            listUber.add(persona21)



            return listUber
        }

        /**
         * nos permite cambiar el vector ( Recurso xml) en Bitmap para setearlo en nuestro marker del mapa
         */
        fun bitamDescriptor(context: Context, @DrawableRes vectorResId: Int): BitmapDescriptor? {

            val vectorDrawable = ContextCompat.getDrawable(
                context,
                vectorResId
            )// Creamos el vector Drawable a partir del recurso

            vectorDrawable!!.setBounds(0, 0, vectorDrawable!!.intrinsicWidth, vectorDrawable.intrinsicHeight)// se obtienen las dimensiones

            val bitMap = Bitmap.createBitmap(vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888)// creamos el bitmap

            val canvas = Canvas(bitMap)// creamos lienzo

            vectorDrawable.draw(canvas)// hacemos dibujo por medio de drawable (seteamos)

            return BitmapDescriptorFactory.fromBitmap(bitMap)// retornamos
        }

        fun createImageFile(context: Context): File? {

            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val imageFileName = "JPEG_" + timeStamp + "_"
            val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val image = File.createTempFile(imageFileName, ".jpg", storageDir)

            return image
        }

        //funcion para cambiar el tamaño al bitmap
        fun getResizedBitmap(bitmap: Bitmap, newHeight: Int, newWidth: Int): Bitmap? {
            val width = bitmap.width
            val height = bitmap.height
            val scaleWidth = newWidth.toFloat() / width
            val scaleHeight = newHeight.toFloat() / height
            // creamos la matrix para manipular
            val matrix = Matrix()
            // cambiamos el tamaño al bitmap
            matrix.postScale(scaleWidth, scaleHeight)
            // recreamos el bitmap
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false)
        }

        // funcion que sirve para rotar la imagen
        fun rotateBitmap(bitmap: Bitmap, degrees: Float): Bitmap? {
            val matrix = Matrix()
            matrix.preRotate(degrees)
            val rotatedBitmap =
                Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
            bitmap.recycle()
            return rotatedBitmap
        }
    }
}
package com.example.mipractica4.utils

import com.example.mipractica4.R

enum class EnumCamionetas {

    CAM1, CAM2, CAM3, CAM4; // Declaramos camionetas del Enum

    companion object{

        //Inicializamos el enum

        fun getFromId(idCamioneta: Int): EnumCamionetas{

            when(idCamioneta){
                1 ->{
                    return CAM1
                }
                2 ->{
                    return CAM2
                }
                3 ->{
                    return CAM3
                }
                4 ->{
                    return CAM4
                }

                else ->{
                    return CAM2 // Declaramos uno por defecto, en caso de que se tenga un identidicador diferente
                }
            }
        }

        /**
         * Obtener el asset
         */

        fun getRecurso(enumCamioneta: EnumCamionetas): Int{

            when(enumCamioneta){

                CAM1 ->{
                    return R.drawable.ic_bicicleta1
                }
                CAM2 ->{
                    return R.drawable.ic_bicicleta2
                }
                CAM3 ->{
                    return R.drawable.ic_repartidor1
                }
                CAM4 ->{
                    return R.drawable.ic_repartidor2
                }
                else ->{
                    return R.drawable.ic_repartidor1
                }
            }
        }
    }
}
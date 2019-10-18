package com.example.yhaa14.utils

import java.io.Serializable

class StyleObject(
    val num:Int=0,
    val colorText: String = "#ffffff",
    val colorBack: String = "none",
    val sizeText: Float =20f,
    val styleText: Int = 0,
    val paddingLeft:Int=0,
    val paddingTop:Int=0,
    val paddingRight:Int=0,
    val paddingButton:Int=0

): Serializable

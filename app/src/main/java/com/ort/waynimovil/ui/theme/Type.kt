package com.ort.waynimovil.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.ort.waynimovil.R

//Regular es 500
//Bold es 700

val manRopeFamily = FontFamily(
    Font(R.font.manrope_extralight, FontWeight.ExtraLight),
    Font(R.font.manrope_light, FontWeight.Light),
    Font(R.font.manrope_regular, FontWeight.Normal),
    Font(R.font.manrope_medium, FontWeight.Medium),
    Font(R.font.manrope_semibold, FontWeight.SemiBold),
    Font(R.font.manrope_bold, FontWeight.Bold),
    Font(R.font.manrope_extrabold, FontWeight.ExtraBold)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 74.sp,  // Convertido directamente de 74px
        lineHeight = 74.sp, // Convertido directamente de 74px
        letterSpacing = (-0.02).em // Copiado directamente de la especificación
    ),
    //Agregar todas las demas
)
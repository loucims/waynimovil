package com.ort.waynimovil.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    displayLarge = TextStyle( // Text XL6
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 74.sp,
        lineHeight = 74.sp,
        letterSpacing = (-0.02).em
    ),
    displayMedium = TextStyle( // Text XL5
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 44.sp,
        lineHeight = 48.4.sp,
        letterSpacing = (-0.01).em,
        textAlign = TextAlign.Left
    ),
    displaySmall = TextStyle( // Text XL4
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 35.2.sp,
        textAlign = TextAlign.Left
    ),
    headlineLarge = TextStyle( // Text XL3, Bold
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 26.4.sp,
        textAlign = TextAlign.Left
    ),
    headlineMedium = TextStyle( // Text XL3, Regular
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 26.4.sp,
        textAlign = TextAlign.Left
    ),
    headlineSmall = TextStyle( // Text XL2, Bold
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        textAlign = TextAlign.Left
    ),
    titleLarge = TextStyle( // Text XL2, Regular
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        textAlign = TextAlign.Left
    ),
    titleMedium = TextStyle( // Text XL1, Bold
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 21.6.sp,
        textAlign = TextAlign.Left
    ),
    titleSmall = TextStyle( // Text XL1, Regular
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 21.6.sp,
        textAlign = TextAlign.Left
    ),
    bodyLarge  = TextStyle( // Text Base, Bold
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 22.4.sp,
        textAlign = TextAlign.Left
    ),
    bodyMedium = TextStyle( // Text Base, Regular
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 22.4.sp,
        textAlign = TextAlign.Left
    ),
    bodySmall = TextStyle( // Text XS1, Bold
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 19.6.sp,
        textAlign = TextAlign.Left
    ),
    labelLarge = TextStyle( // Text XS1, Regular
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 19.6.sp,
        textAlign = TextAlign.Left
    ),
    labelMedium = TextStyle( // Text XS2, Bold
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 14.4.sp,
        textAlign = TextAlign.Left
    ),
    labelSmall = TextStyle( // Text XS2, Regular
        fontFamily = manRopeFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 14.4.sp,
        textAlign = TextAlign.Left
    )

)
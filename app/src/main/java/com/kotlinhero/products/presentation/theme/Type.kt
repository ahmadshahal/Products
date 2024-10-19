package com.kotlinhero.products.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kotlinhero.products.R

val metropolisFontFamily = FontFamily(
    Font(R.font.metropolis_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.metropolis_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.metropolis_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.metropolis_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.metropolis_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.metropolis_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.metropolis_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.metropolis_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.metropolis_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.metropolis_extra_bold, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.metropolis_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.metropolis_extra_light, FontWeight.ExtraLight, FontStyle.Normal),
    Font(R.font.metropolis_extra_light_italic, FontWeight.ExtraLight, FontStyle.Italic)
)

val Typography = Typography(
    labelMedium = TextStyle(
        fontFamily = metropolisFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
        lineHeight = (8 * 1.2).sp,
    ),
    labelLarge = TextStyle(
        fontFamily = metropolisFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = (10 * 1.2).sp,
    ),
    bodySmall = TextStyle(
        fontFamily = metropolisFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = (11 * 1.2).sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = metropolisFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = (14 * 1.2).sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = metropolisFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = (16 * 1.2).sp,
    ),
    titleSmall = TextStyle(
        fontFamily = metropolisFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = (18 * 1.2).sp,
    ),
    titleMedium = TextStyle(
        fontFamily = metropolisFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = (22 * 1.2).sp,
    ),
    titleLarge = TextStyle(
        fontFamily = metropolisFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = (24 * 1.2).sp,
    ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
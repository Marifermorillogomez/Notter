package com.codmari.noter.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.codmari.noter.R

val AveriaSansLibreFamily = FontFamily(
    Font(R.font.averia_sanslibre_bold, FontWeight.Bold),
    Font(R.font.averia_sanslibre_light, FontWeight.Light),
    Font(R.font.averia_sanslibre_regular, FontWeight.Normal),
    Font(R.font.averia_sanslibre_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.averia_sanslibre_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.averia_sanslibre_lightitalic, FontWeight.Light, FontStyle.Italic),
)
val MontSerrantAlternativeFamily = FontFamily(
    Font(R.font.montserrat_alternates_bold, FontWeight.Bold),
    Font(R.font.montserrat_alternates_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.montserrat_alternates_extrabold, FontWeight.ExtraBold),
    Font(R.font.montserrat_alternates_extrabolditalic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.montserrat_alternates_semibold, FontWeight.SemiBold),
    Font(R.font.montserrat_alternates_semibolditalic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.montserrat_alternates_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.montserrat_alternates_black, FontWeight.Black,),
    Font(R.font.montserrat_alternates_blackitalic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.montserrat_alternates_regular, FontWeight.Normal),
    Font(R.font.montserrat_alternates_light, FontWeight.Light,),
    Font(R.font.montserrat_alternates_lightitalic, FontWeight.Light, FontStyle.Italic,),
    Font(R.font.montserrat_alternates_thin, FontWeight.Thin, ),
    Font(R.font.montserrat_alternates_thinitalic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.montserrat_alternates_medium, FontWeight.Medium, ),
    Font(R.font.montserrat_alternates_mediumitalic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.montserrat_alternates_extralight, FontWeight.ExtraLight, ),
    Font(R.font.montserrat_alternates_extralightitalic, FontWeight.ExtraLight, FontStyle.Italic),

)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = MontSerrantAlternativeFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),

    /* Other default text styles to override
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)


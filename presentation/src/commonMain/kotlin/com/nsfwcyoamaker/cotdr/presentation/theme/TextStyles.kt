package com.nsfwcyoamaker.cotdr.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.Font

@get:Composable
private val MinioProFontFamily
    get() = FontFamily(
        Font(Res.font.MinionPro_Bold, weight = FontWeight.Bold, style = FontStyle.Normal),
        Font(Res.font.MinionPro_BoldIt, weight = FontWeight.Bold, style = FontStyle.Italic),
        Font(Res.font.MinionPro_It, weight = FontWeight.Normal, style = FontStyle.Italic),
        Font(Res.font.MinionPro_Medium, weight = FontWeight.Medium, style = FontStyle.Normal),
        Font(Res.font.MinionPro_MediumIt, weight = FontWeight.Medium, style = FontStyle.Italic),
        Font(Res.font.MinionPro_Regular, weight = FontWeight.Normal, style = FontStyle.Normal),
        Font(Res.font.MinionPro_Semibold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
        Font(Res.font.MinionPro_SemiboldIt, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    )

@get:Composable
val defaultTextStyle
    get() = TextStyle(
        fontSize = 16.sp,
        lineHeight = 20.sp,
        color = Color.White,
        fontFamily = MinioProFontFamily,
    )

@get:Composable
val bigTitleTextStyle
    get() = TextStyle(
        fontSize = 126.sp,
        lineHeight = 132.sp,
        color = Color.White,
        fontFamily = MinioProFontFamily,
    )

@get:Composable
val mediumTitleTextStyle
    get() = TextStyle(
        fontSize = 68.sp,
        lineHeight = 74.sp,
        color = Color.White,
        fontFamily = MinioProFontFamily,
    )

@get:Composable
val smallTitleTextStyle
    get() = TextStyle(
        fontSize = 48.sp,
        lineHeight = 52.sp,
        color = Color.White,
        fontFamily = MinioProFontFamily,
    )

@get:Composable
val smallerTextStyle
    get() = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        color = Color.White,
        fontFamily = MinioProFontFamily,
    )

@get:Composable
private val AngloTextFontFamily
    get() = FontFamily(Font(Res.font.AngloText, weight = FontWeight.Normal))

@get:Composable
val angloTextStyle: TextStyle
    get() = TextStyle(
        fontFamily = AngloTextFontFamily,
    )

@get:Composable
val angloGlowTextStyle: TextStyle
    get() = TextStyle(
        fontFamily = AngloTextFontFamily,
        shadow = Shadow(
            color = Color.White,
            offset = Offset.Zero,
            blurRadius = 24f,
        )
    )

@get:Composable
val acerolaTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = AcerolaColor,
    )

@get:Composable
val celesteTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = CelesteColor,
    )

@get:Composable
val desuriTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = DesuriColor,
    )

@get:Composable
val erinaTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = ErinaColor,
    )

@get:Composable
val helenaTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = HelenaColor,
    )

@Composable
private fun priestessTitleTextStyle(
    shadowColor: Color
): TextStyle = angloTextStyle.copy(
    shadow = Shadow(
        color = shadowColor,
        offset = Offset.Zero,
        blurRadius = 24f,
    )
)

@get:Composable
val acerolaTitleTextStyle: TextStyle
    get() = priestessTitleTextStyle(AcerolaColor)

@get:Composable
val celesteTitleTextStyle: TextStyle
    get() = priestessTitleTextStyle(CelesteColor)

@get:Composable
val desuriTitleTextStyle: TextStyle
    get() = priestessTitleTextStyle(DesuriColor)

@get:Composable
val erinaTitleTextStyle: TextStyle
    get() = priestessTitleTextStyle(ErinaColor)

@get:Composable
val helenaTitleTextStyle: TextStyle
    get() = priestessTitleTextStyle(HelenaColor)
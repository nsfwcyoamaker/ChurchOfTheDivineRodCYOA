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
        fontSize = 18.sp,
        lineHeight = 20.sp,
        color = Color.White,
        fontFamily = MinioProFontFamily,
    )

@get:Composable
val captionTextStyle
    get() = TextStyle(
        fontSize = 15.sp,
        lineHeight = 18.sp,
        color = Color.White,
        fontFamily = MinioProFontFamily,
    )

@get:Composable
val smallTextStyle
    get() = TextStyle(
        fontSize = 13.sp,
        lineHeight = 16.sp,
        color = Color.White,
        fontFamily = MinioProFontFamily,
    )

@get:Composable
val headerTextStyle
    get() = TextStyle(
        fontSize = 24.sp,
        lineHeight = 28.sp,
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
private val AnglicanTextFontFamily
    get() = FontFamily(Font(Res.font.Anglican_Regular, weight = FontWeight.Normal))

@get:Composable
val AngloTextStyle: TextStyle
    get() = TextStyle(
        fontFamily = AnglicanTextFontFamily,
    )

@get:Composable
val AngloGlowTextStyle: TextStyle
    get() = TextStyle(
        fontFamily = AnglicanTextFontFamily,
        shadow = Shadow(
            color = Color.White,
            offset = Offset.Zero,
            blurRadius = 24f,
        )
    )

@get:Composable
val AcerolaTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = AcerolaColor,
    )

@get:Composable
val CelesteTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = CelesteColor,
    )

@get:Composable
val DesuriTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = DesuriColor,
    )

@get:Composable
val ErinaTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = ErinaColor,
    )

@get:Composable
val HelenaTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = HelenaColor,
    )

@get:Composable
val BambinaTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = BambinaColor,
    )

@get:Composable
val FuukaTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = FuukaColor,
    )

@get:Composable
val SophiaTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = SophiaColor,
    )

@get:Composable
val GracidiaTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = GracidiaColor,
    )

@get:Composable
val SashaTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = SashaColor,
    )

@get:Composable
val TeresaTextStyle: TextStyle
    get() = TextStyle(
        fontStyle = FontStyle.Italic,
        color = TeresaColor,
    )

@Composable
private fun priestessTitleTextStyle(
    shadowColor: Color
): TextStyle = AngloTextStyle.copy(
    shadow = Shadow(
        color = shadowColor,
        offset = Offset.Zero,
        blurRadius = 24f,
    )
)

@get:Composable
val AcerolaTitleTextStyle: TextStyle
    get() = priestessTitleTextStyle(AcerolaColor)

@get:Composable
val CelesteTitleTextStyle: TextStyle
    get() = priestessTitleTextStyle(CelesteColor)

@get:Composable
val DesuriTitleTextStyle: TextStyle
    get() = priestessTitleTextStyle(DesuriColor)

@get:Composable
val ErinaTitleTextStyle: TextStyle
    get() = priestessTitleTextStyle(ErinaColor)

@get:Composable
val HelenaTitleTextStyle: TextStyle
    get() = priestessTitleTextStyle(HelenaColor)
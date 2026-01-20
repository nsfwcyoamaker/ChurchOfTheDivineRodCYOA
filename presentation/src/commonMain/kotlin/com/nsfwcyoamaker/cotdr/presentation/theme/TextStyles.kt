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
import com.nsfwcyoamaker.cotdr.resources.AngloText
import com.nsfwcyoamaker.cotdr.resources.Res
import org.jetbrains.compose.resources.Font

val defaultTextStyle = TextStyle(
    fontSize = 16.sp,
    lineHeight = 20.sp,
    color = Color.White,
)

val smallerTextStyle = TextStyle(
    fontSize = 12.sp,
    lineHeight = 16.sp,
    color = Color.White,
)

@get:Composable
val AngloTextFontFamily
    get() = FontFamily(Font(Res.font.AngloText, weight = FontWeight.Normal))

@get:Composable
val mainTitleTextStyle: TextStyle
    get() = TextStyle(
        fontFamily = AngloTextFontFamily,
        color = Color.White,
        fontSize = 126.sp,
        shadow = Shadow(
            color = Color.White,
            offset = Offset.Zero,
            blurRadius = 24f,
        )
    )

@get:Composable
val sectionTitleTextStyle: TextStyle
    get() = TextStyle(
        fontFamily = AngloTextFontFamily,
        color = Color.White,
        fontSize = 68.sp,
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
): TextStyle = mainTitleTextStyle.copy(
    fontSize = 48.sp,
    shadow = Shadow(
        color = shadowColor,
        offset = Offset.Zero,
        blurRadius = 24f,
    )
)

@get:Composable
val genericPriestessTitleTextStyle: TextStyle
    get() = priestessTitleTextStyle(Color.White)

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
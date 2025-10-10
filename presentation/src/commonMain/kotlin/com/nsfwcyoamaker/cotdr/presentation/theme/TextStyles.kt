package com.nsfwcyoamaker.cotdr.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nsfwcyoamaker.cotdr.resources.Anglo_Text
import com.nsfwcyoamaker.cotdr.resources.Res
import org.jetbrains.compose.resources.Font

@get:Composable
val AngloTextFontFamily
    get() = FontFamily(Font(Res.font.Anglo_Text, weight = FontWeight.Normal))

@get:Composable
val mainTitleTextStyle: TextStyle
    get() = TextStyle(
        fontFamily = AngloTextFontFamily,
        color = Color.White,
        fontSize = 80.sp,
        shadow = Shadow(
            color = Color.White,
            offset = Offset.Zero,
            blurRadius = 12f,
        )
    )

@get:Composable
val sectionTitleTextStyle: TextStyle
    get() = TextStyle(
        fontFamily = AngloTextFontFamily,
        color = Color.White,
        fontSize = 68.sp,
    )
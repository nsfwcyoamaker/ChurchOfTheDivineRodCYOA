package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.nsfwcyoamaker.cotdr.presentation.theme.acerolaTextStyle
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun PriestessIntroductionInterlude(
    modifier: Modifier = Modifier,
) {
    HighlightCenter(modifier = modifier) {
        Image(
            painter = painterResource(Res.drawable.priestess_introduction_interlude),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .wrapContentHeight()
                .shadowBorder()
        )
    }
}
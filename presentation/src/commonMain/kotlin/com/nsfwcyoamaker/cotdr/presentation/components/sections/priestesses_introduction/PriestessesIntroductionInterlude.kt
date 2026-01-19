package com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.nsfwcyoamaker.cotdr.presentation.components.HighlightCenter
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_interlude
import org.jetbrains.compose.resources.painterResource

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
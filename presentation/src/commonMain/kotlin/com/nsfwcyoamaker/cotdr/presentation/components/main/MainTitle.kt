package com.nsfwcyoamaker.cotdr.presentation.components.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.presentation.theme.bigTitleTextStyle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.title

@Composable
fun MainTitle(
    modifier: Modifier = Modifier,
) {
    Text(
        text = rememberRichTextResource(Res.string.title),
        style = bigTitleTextStyle,
        textAlign = TextAlign.Center,
        modifier = modifier,
    )
}
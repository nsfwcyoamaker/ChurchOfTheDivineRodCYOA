package com.nsfwcyoamaker.cotdr.presentation.components.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.nsfwcyoamaker.cotdr.presentation.theme.mainTitleTextStyle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.title
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainTitle(
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(Res.string.title),
        style = mainTitleTextStyle,
        textAlign = TextAlign.Center,
        modifier = modifier,
    )
}
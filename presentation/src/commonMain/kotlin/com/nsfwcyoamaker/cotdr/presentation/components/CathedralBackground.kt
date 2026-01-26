package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.cathedral_bg_preprocessed
import org.jetbrains.compose.resources.painterResource

@Composable
fun CathedralBackground(
    modifier: Modifier = Modifier,
) {
    Image(
        contentDescription = null,
        painter = painterResource(Res.drawable.cathedral_bg_preprocessed),
        modifier = modifier,
        contentScale = ContentScale.Crop,
    )
}
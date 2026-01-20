package com.nsfwcyoamaker.cotdr.presentation.components.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.composableTextFlow.TextFlow
import com.nsfwcyoamaker.cotdr.composableTextFlow.TextWrapPlacement
import com.nsfwcyoamaker.cotdr.presentation.PreviewScope
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.presentation.utils.rich_text.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.intro_priestess
import com.nsfwcyoamaker.cotdr.resources.main_intro
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MainIntroduction(
    modifier: Modifier = Modifier,
) {
    TextFlow(
        text = rememberRichTextResource(Res.string.main_intro),
        modifier = modifier,
        placement = TextWrapPlacement.TopEnd,
        horizontalGap = 12.dp,
        verticalGap = 4.dp,
        component = {
            Image(
                painter = painterResource(Res.drawable.intro_priestess),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth(0.22f)
                    .wrapContentHeight()
                    .shadowBorder(),
            )
        },
    )
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
fun MainIntroductionPreview() {
    PreviewScope {
        MainIntroduction(
            modifier = Modifier.fillMaxSize(),
        )
    }
}
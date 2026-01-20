package com.nsfwcyoamaker.cotdr.presentation.components.sections.fervor

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nsfwcyoamaker.cotdr.composableTextFlow.TextFlow
import com.nsfwcyoamaker.cotdr.composableTextFlow.TextWrapPlacement
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.presentation.utils.rich_text.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.fervor_intro
import com.nsfwcyoamaker.cotdr.resources.main_intro
import org.jetbrains.compose.resources.painterResource

@Composable
fun FervorDescription(
    modifier: Modifier = Modifier,
) {
    TextFlow(
        text = rememberRichTextResource(Res.string.main_intro), //todo
        modifier = modifier,
        placement = TextWrapPlacement.TopEnd,
        horizontalGap = 12.dp,
        verticalGap = 4.dp,
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = Color.White,
        ),
        component = {
            Image(
                painter = painterResource(Res.drawable.fervor_intro),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth(0.22f)
                    .wrapContentHeight()
                    .shadowBorder()
                    .scale(scaleX = -1f, scaleY = 1f),
            )
        },
    )
}
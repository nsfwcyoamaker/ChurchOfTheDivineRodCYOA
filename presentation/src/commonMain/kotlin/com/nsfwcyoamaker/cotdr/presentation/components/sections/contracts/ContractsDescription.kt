package com.nsfwcyoamaker.cotdr.presentation.components.sections.contracts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.composableTextFlow.TextFlow
import com.nsfwcyoamaker.cotdr.composableTextFlow.TextWrapPlacement
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_contracts_descriprion
import com.nsfwcyoamaker.cotdr.resources.section_contracts_intro
import org.jetbrains.compose.resources.painterResource

@Composable
fun ContractsDescription(
    modifier: Modifier = Modifier,
) {
    TextFlow(
        text = rememberRichTextResource(Res.string.section_contracts_descriprion),
        modifier = modifier,
        placement = TextWrapPlacement.TopStart,
        horizontalGap = 12.dp,
        verticalGap = 4.dp,
        component = {
            Image(
                painter = painterResource(Res.drawable.section_contracts_intro),
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
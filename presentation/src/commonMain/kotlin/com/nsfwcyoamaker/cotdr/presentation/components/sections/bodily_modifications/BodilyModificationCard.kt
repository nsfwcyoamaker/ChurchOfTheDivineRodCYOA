package com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.SelectableCard
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationOption
import com.nsfwcyoamaker.cotdr.presentation.theme.smallTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.smallerTextStyle
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BodilyModificationCard(
    bodilyModification: BodilyModificationOption,
    isSelected: Boolean,
    isClickable: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = isSelected,
        isClickable = isClickable,
        onSelected = onSelected,
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Image(
                painter = painterResource(bodilyModification.image),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .background(color = Color.Black)
                    .weight(1f)
                    .fillMaxHeight()
                    .shadowBorder()
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = rememberRichTextResource(bodilyModification.title),
                    style = smallTitleTextStyle,
                )

                Text(
                    text = rememberRichTextResource(bodilyModification.description),
                    style = smallerTextStyle,
                )

                Box(modifier = Modifier.weight(1f))

                Text(
                    text = rememberRichTextResource(bodilyModification.cost),
                )
            }
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun BodilyModificationCardPreview() {
    AppScope {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            BodilyModificationCard(
                bodilyModification = BodilyModificationOption.BodyRemodeling,
                isSelected = false,
                isClickable = false,
                onSelected = {},
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .wrapContentHeight(),
            )
        }
    }
}
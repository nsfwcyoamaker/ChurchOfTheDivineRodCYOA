package com.nsfwcyoamaker.cotdr.presentation.components.sections.church_appeal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.SelectableCard
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.presentation.model.ChurchAppealOption
import com.nsfwcyoamaker.cotdr.presentation.model.ChurchAppealState
import com.nsfwcyoamaker.cotdr.presentation.theme.smallerTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.smallerTitleTextStyle
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ChurchAppealCard(
    state: ChurchAppealState,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = state.isSelected,
        isClickable = state.isEnabled,
        onSelected = onSelected,
        modifier = modifier,
        cornerBracketsVisible = false,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Image(
                    painter = painterResource(state.option.image),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentHeight()
                        .shadowBorder(),
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = rememberRichTextResource(state.option.title),
                        style = smallerTitleTextStyle,
                    )

                    Text(
                        text = rememberRichTextResource(state.option.description),
                        style = smallerTextStyle,
                    )

                    Text("", style = smallerTextStyle)

                    Text(
                        text = rememberRichTextResource(state.option.effect),
                        style = smallerTextStyle,
                    )
                }
            }

            Text(
                text = rememberRichTextResource(state.option.comment),
            )
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun ChurchAppealCardPreview() {
    AppScope {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            ChurchAppealCard(
                state = ChurchAppealState(ChurchAppealOption.HardNo),
                onSelected = {},
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .wrapContentHeight(),
            )
        }
    }
}
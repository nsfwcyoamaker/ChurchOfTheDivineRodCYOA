package com.nsfwcyoamaker.cotdr.presentation.components.sections.brands

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
import com.nsfwcyoamaker.cotdr.presentation.model.ExperimentalBrandOption
import com.nsfwcyoamaker.cotdr.presentation.model.ExperimentalBrandState
import com.nsfwcyoamaker.cotdr.presentation.theme.smallTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.smallerTextStyle
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ExperimentalBrandCard(
    state: ExperimentalBrandState,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = state.isSelected,
        isClickable = state.isEnabled,
        onSelected = onSelected,
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.Top,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp, alignment = Alignment.Top),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = rememberRichTextResource(state.option.title),
                    style = smallTitleTextStyle,
                )

                state.option.image?.let {
                    Image(
                        painter = painterResource(it),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .wrapContentHeight()
                            .shadowBorder()
                    )
                }

                Box(modifier = Modifier.weight(1f))
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = rememberRichTextResource(state.option.description),
                    style = smallerTextStyle,
                )

                Box(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun ExperimentalBrandCardPreview() {
    AppScope {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            ExperimentalBrandCard(
                state = ExperimentalBrandState(ExperimentalBrandOption.Pupil),
                onSelected = {},
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .wrapContentHeight(),
            )
        }
    }
}
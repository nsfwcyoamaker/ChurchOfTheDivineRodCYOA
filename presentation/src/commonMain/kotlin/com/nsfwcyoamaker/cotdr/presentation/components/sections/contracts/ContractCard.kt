package com.nsfwcyoamaker.cotdr.presentation.components.sections.contracts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.HighlightCenter
import com.nsfwcyoamaker.cotdr.presentation.components.SelectableCard
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.presentation.model.ContractOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractState
import com.nsfwcyoamaker.cotdr.presentation.theme.smallTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.smallerTextStyle
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ContractCard(
    state: ContractState,
    onSelected: () -> Unit,
    onAlternativeSelected: (ContractState.AlternativeState) -> Unit,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = state.isSelected,
        isClickable = state.isEnabled,
        onSelected = onSelected,
        modifier = modifier,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            HighlightCenter(
                inverted = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = rememberRichTextResource(state.option.title),
                    style = smallTitleTextStyle,
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.Top,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp, alignment = Alignment.Top),
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(state.option.demonImage),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .wrapContentHeight()
                            .shadowBorder()
                    )

                    Box(modifier = Modifier.weight(1f))
                }

                Column(
                    modifier = Modifier.weight(2f),
                ) {
                    Text(
                        text = rememberRichTextResource(state.option.selfDescription),
                        style = smallerTextStyle,
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                            .padding(horizontal = 2.dp),
                    ) {
                        state.alternatives.forEach { alternative ->
                            AlternativeCard(
                                alternative = alternative,
                                onClick = { onAlternativeSelected(alternative) },
                                modifier = Modifier.weight(1f).fillMaxHeight(),
                            )
                        }
                    }

                    Box(modifier = Modifier.weight(1f))

                    Text(
                        text = rememberRichTextResource(state.option.priestessDescription),
                        style = smallerTextStyle,
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp, alignment = Alignment.Top),
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(state.option.nunImage),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .wrapContentHeight()
                            .shadowBorder()
                    )

                    Box(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun AlternativeCard(
    alternative: ContractState.AlternativeState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = alternative.isSelected,
        isClickable = true,
        onSelected = onClick,
        cornerBracketsVisible = false,
        modifier = modifier,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = rememberRichTextResource(alternative.contractAlternative.text),
                style = smallerTextStyle,
                textAlign = TextAlign.Center,
            )

            Text(
                text = rememberRichTextResource(alternative.contractAlternative.description),
                style = smallerTextStyle,
                textAlign = TextAlign.Justify,
            )
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun ContractCardPreview() {
    AppScope {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            ContractCard(
                state = ContractState(ContractOption.FelicLusch),
                onSelected = {},
                onAlternativeSelected = {},
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .wrapContentHeight(),
            )
        }
    }
}
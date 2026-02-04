package com.nsfwcyoamaker.cotdr.presentation.components.sections.rulings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.presentation.components.SelectableCard
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.presentation.model.RulingOption
import com.nsfwcyoamaker.cotdr.presentation.model.RulingState
import com.nsfwcyoamaker.cotdr.presentation.screens.rulings.RulingsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.rulings.action.ToggleRulingOptionAction
import com.nsfwcyoamaker.cotdr.presentation.theme.smallTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.smallerTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.smallerTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.tinyTitleTextStyle
import org.jetbrains.compose.resources.painterResource

@Composable
fun RulingsGrid(
    rulings: List<RulingOption>,
    rulingStateProvider: @Composable (RulingOption.Option) -> RulingState.RulingOptionState,
    onRulingAction: (RulingsSelectionAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = false,
        isClickable = false,
        onSelected = {},
        modifier = modifier,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            rulings.forEach { option ->
                SectionTitle(
                    title = option.title,
                    modifier = Modifier.fillMaxWidth(),
                    style = smallerTitleTextStyle,
                    iconSize = 32.dp,
                )
                Text(
                    text = rememberRichTextResource(option.description),
                    modifier = Modifier.fillMaxWidth(),
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                ) {
                    option.alternatives.forEach { alternative ->
                        val state = rulingStateProvider(alternative)

                        SelectableCard(
                            isSelected = state.isSelected,
                            isClickable = true,
                            onSelected = { onRulingAction(ToggleRulingOptionAction(alternative.originalRulingOption)) },
                            cornerBracketsVisible = false,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                modifier = Modifier.fillMaxSize(),
                            ) {
                                Image(
                                    painter = painterResource(alternative.image),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillWidth,
                                    modifier = Modifier
                                        .weight(1f)
                                        .wrapContentHeight()
                                        .shadowBorder()
                                )

                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .wrapContentHeight(),
                                ) {
                                    Text(
                                        text = rememberRichTextResource(alternative.title),
                                        style = tinyTitleTextStyle,
                                        modifier = Modifier.fillMaxWidth(),
                                    )

                                    Text(
                                        text = rememberRichTextResource(alternative.description),
                                        style = smallerTextStyle,
                                        modifier = Modifier.fillMaxWidth(),
                                    )

                                    Text(
                                        text = "",
                                        style = smallTextStyle,
                                        modifier = Modifier.fillMaxWidth(),
                                    )

                                    Text(
                                        text = rememberRichTextResource(alternative.cost),
                                        style = smallTextStyle,
                                        modifier = Modifier.fillMaxWidth(),
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
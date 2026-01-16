package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroduction
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PriestessesIntroductionGrid(
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(modifier = modifier) {
        val minItemWidth = 300.dp
        val spacing = 24.dp
        val itemsAmountPerRow = 3

        val rowSize = (minItemWidth * itemsAmountPerRow) + (spacing * (itemsAmountPerRow - 1))

        if(rowSize < maxWidth) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
            ) {
                val priestessesByRow = remember { PriestessIntroduction.entries.chunked(3) }

                priestessesByRow.forEach { priestessesRow ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                    ) {
                        priestessesRow.forEach { priestess ->
                            FollowerIntroduction(
                                title = priestess.getTitleText(),
                                titleStyle = priestess.getTitleStyle(),
                                image = priestess.image,
                                description = priestess.getDescription(),
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight(),
                            )
                        }
                    }
                }
            }
        } else {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
                maxItemsInEachRow = 3,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
            ) {
                val priestesses = remember { PriestessIntroduction.entries.toList() }

                priestesses.forEach { priestess ->
                    FollowerIntroduction(
                        title = priestess.getTitleText(),
                        titleStyle = priestess.getTitleStyle(),
                        image = priestess.image,
                        description = priestess.getDescription(),
                        modifier = Modifier
                            .requiredWidth(minItemWidth)
                            .fillMaxRowHeight(),
                    )
                }
            }
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun PriestessesIntroductionGridPreview() {
    PriestessesIntroductionGrid(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .padding(horizontal = 80.dp)
            .verticalScroll(rememberScrollState())
    )
}
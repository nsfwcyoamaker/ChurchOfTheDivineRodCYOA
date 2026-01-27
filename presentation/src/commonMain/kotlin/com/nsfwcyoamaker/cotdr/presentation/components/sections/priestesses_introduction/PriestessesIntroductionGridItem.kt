package com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroductionOption
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts.ConsortsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts.ConsortsSelectionState
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts.action.TogglePriestessAction
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.PriestessesIntroductionGridItem(
    consortsState: ConsortsSelectionState,
    onConsortsAction: (ConsortsSelectionAction) -> Unit,
) {
    consortsState.priestessesState.forEachIndexed { index, priestessesRow ->
        item(
            key = "priestesses_introduction_row_$index",
            contentType = "priestesses_introduction_row"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                priestessesRow.forEach { priestessState ->
                    PriestessIntroductionCard(
                        priestessUi = priestessState.priestessIntroductionOption.ui,
                        isClickable = priestessState.isClickable,
                        isSelected = priestessState.isSelected,
                        onSelected = { onConsortsAction(TogglePriestessAction(priestessState.priestessIntroductionOption)) },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                    )
                }

                if(index == consortsState.priestessesState.size - 1) {
                    PriestessIntroductionCard(
                        priestessUi = PriestessIntroductionOption.consortsUi,
                        isClickable = false,
                        isSelected = false,
                        onSelected = {},
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                    )
                }
            }
        }

        if(index < (consortsState.priestessesState.size - 1)) {
            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun PriestessesIntroductionGridItemPreview() {
    AppScope {
        MainScreenList {
            PriestessesIntroductionGridItem(
                consortsState = ConsortsSelectionState(),
                onConsortsAction = {}
            )
        }
    }
}
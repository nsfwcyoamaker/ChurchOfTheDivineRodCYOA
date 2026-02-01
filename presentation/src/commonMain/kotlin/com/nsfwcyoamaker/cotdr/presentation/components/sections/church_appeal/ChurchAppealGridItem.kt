package com.nsfwcyoamaker.cotdr.presentation.components.sections.church_appeal

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.ChoicesGrid
import com.nsfwcyoamaker.cotdr.presentation.model.ChurchAppealOption
import com.nsfwcyoamaker.cotdr.presentation.model.ChurchAppealState
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal.ChurchAppealSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal.action.ToggleChurchAppealAction
import org.jetbrains.compose.ui.tooling.preview.Preview

fun LazyListScope.ChurchAppealGridItem(
    churchAppealProvider: @Composable (ChurchAppealOption) -> ChurchAppealState,
    onChurchAppealAction: (ChurchAppealSelectionAction) -> Unit
) {
    ChoicesGrid(
        items = ChurchAppealOption.entries,
        columns = 3,
        key = "church_appeal_row",
        contentType = "church_appeal_row",
        itemContent = { option ->
            val state = churchAppealProvider.invoke(option)
            ChurchAppealCard(
                state = state,
                onSelected = { onChurchAppealAction(ToggleChurchAppealAction(option.choice)) },
            )
        },
    )
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun ChurchAppealGridItemPreview() {
    AppScope {
        MainScreenList {
            ChurchAppealGridItem(
                { option -> ChurchAppealState(option) },
                {},
            )
        }
    }
}
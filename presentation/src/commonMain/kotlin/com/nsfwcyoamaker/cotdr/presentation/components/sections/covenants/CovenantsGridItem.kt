package com.nsfwcyoamaker.cotdr.presentation.components.sections.covenants

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.ChoicesGrid
import com.nsfwcyoamaker.cotdr.presentation.model.CovenantOption
import com.nsfwcyoamaker.cotdr.presentation.model.CovenantState
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.action.CovenantClickedAction
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.CovenantsGridItem(
    itemStateProvider: @Composable (CovenantOption) -> CovenantState,
    onCovenantAction: (CovenantsSelectionAction) -> Unit
) {
    ChoicesGrid(
        items = CovenantOption.entries,
        columns = 3,
        key = "covenants_row",
        contentType = "covenants_row",
        itemContent = { option ->
            val state = itemStateProvider.invoke(option)
            CovenantCard(
                state = state,
                onSelected = { onCovenantAction(CovenantClickedAction(option.choice)) },
            )
        },
    )
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun CovenantsGridItemPreview() {
    AppScope {
        MainScreenList {
            CovenantsGridItem(
                { option -> CovenantState(option) },
                {},
            )
        }
    }
}
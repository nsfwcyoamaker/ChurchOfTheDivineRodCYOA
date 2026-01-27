package com.nsfwcyoamaker.cotdr.presentation.components.sections.covenants

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.ChoicesGrid
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionState
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.action.CovenantClickedAction
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.CovenantsGridItem(
    covenantsSelectionState: CovenantsSelectionState,
    onCovenantAction: (CovenantsSelectionAction) -> Unit
) {
    ChoicesGrid(
        items = covenantsSelectionState.items,
        columns = 3,
        key = "covenants_row",
        contentType = "covenants_row",
        itemContent = { item ->
            CovenantCard(
                state = item,
                onSelected = { onCovenantAction(CovenantClickedAction(item.option.choice)) },
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
                CovenantsSelectionState(),
                {},
            )
        }
    }
}
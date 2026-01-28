package com.nsfwcyoamaker.cotdr.presentation.components.sections.brands

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.ChoicesGrid
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.ExperimentalBrandsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.ExperimentalBrandsSelectionState
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.action.ToggleExperimentalBrandAction
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.ExperimentalBrandsGridItem(
    experimentalBrandsState: ExperimentalBrandsSelectionState,
    onExperimentalBrandAction: (ExperimentalBrandsSelectionAction) -> Unit
) {
    ChoicesGrid(
        items = experimentalBrandsState.items,
        columns = 3,
        key = "experimental_brands_row",
        contentType = "experimental_brands_row",
        itemContent = { item ->
            ExperimentalBrandCard(
                state = item,
                onSelected = { onExperimentalBrandAction(ToggleExperimentalBrandAction(item.option.choice)) },
            )
        },
    )
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun ExperimentalBrandsGridItemPreview() {
    AppScope {
        MainScreenList {
            ExperimentalBrandsGridItem(
                experimentalBrandsState = ExperimentalBrandsSelectionState(),
                onExperimentalBrandAction = {},
            )
        }
    }
}
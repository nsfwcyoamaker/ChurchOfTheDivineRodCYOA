package com.nsfwcyoamaker.cotdr.presentation.components.sections.brands

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.ChoicesGrid
import com.nsfwcyoamaker.cotdr.presentation.model.ExperimentalBrandOption
import com.nsfwcyoamaker.cotdr.presentation.model.ExperimentalBrandState
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.ExperimentalBrandsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.action.ToggleExperimentalBrandAction
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.ExperimentalBrandsGridItem(
    itemStateProvider: @Composable (ExperimentalBrandOption) -> ExperimentalBrandState,
    onExperimentalBrandAction: (ExperimentalBrandsSelectionAction) -> Unit
) {
    ChoicesGrid(
        items = ExperimentalBrandOption.entries,
        columns = 3,
        key = "experimental_brands_row",
        contentType = "experimental_brands_row",
        itemContent = { option ->
            val state = itemStateProvider(option)
            ExperimentalBrandCard(
                state = state,
                onSelected = { onExperimentalBrandAction(ToggleExperimentalBrandAction(option.choice)) },
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
                { option -> ExperimentalBrandState(option) },
                onExperimentalBrandAction = {},
            )
        }
    }
}
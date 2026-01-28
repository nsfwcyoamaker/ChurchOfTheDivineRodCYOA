package com.nsfwcyoamaker.cotdr.presentation.components.sections.brands

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.ChoicesGrid
import com.nsfwcyoamaker.cotdr.presentation.model.BrandOption
import com.nsfwcyoamaker.cotdr.presentation.model.BrandState
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.action.ToggleBrandAction
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.BrandsGridItem(
    itemStateProvider: @Composable (BrandOption) -> BrandState,
    onBrandAction: (BrandsSelectionAction) -> Unit
) {
    ChoicesGrid(
        items = BrandOption.entries,
        columns = 3,
        key = "brands_row",
        contentType = "brands_row",
        itemContent = { option ->
            val state = itemStateProvider(option)
            BrandCard(
                state = state,
                onSelected = { onBrandAction(ToggleBrandAction(option.choice)) },
            )
        },
    )
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun BrandsGridItemPreview() {
    AppScope {
        MainScreenList {
            BrandsGridItem(
                { option -> BrandState(option) },
                onBrandAction = {},
            )
        }
    }
}
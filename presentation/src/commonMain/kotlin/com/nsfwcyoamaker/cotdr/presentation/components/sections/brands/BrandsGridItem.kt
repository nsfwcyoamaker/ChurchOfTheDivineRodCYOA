package com.nsfwcyoamaker.cotdr.presentation.components.sections.brands

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.ChoicesGrid
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionState
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.action.ToggleBrandAction
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.BrandsGridItem(
    brandsState: BrandsSelectionState,
    onBrandAction: (BrandsSelectionAction) -> Unit
) {
    ChoicesGrid(
        items = brandsState.items,
        columns = 3,
        key = "brands_row",
        contentType = "brands_row",
        itemContent = { item ->
            BrandCard(
                state = item,
                onSelected = { onBrandAction(ToggleBrandAction(item.option.choice)) },
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
                brandsState = BrandsSelectionState(),
                onBrandAction = {},
            )
        }
    }
}
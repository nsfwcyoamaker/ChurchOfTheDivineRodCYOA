package com.nsfwcyoamaker.cotdr.presentation.components.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.sections.brands.*
import com.nsfwcyoamaker.cotdr.presentation.components.sections.history.HistoryDescription
import com.nsfwcyoamaker.cotdr.presentation.components.sections.history.HistoryTitle
import com.nsfwcyoamaker.cotdr.presentation.model.BrandOption
import com.nsfwcyoamaker.cotdr.presentation.model.BrandState
import com.nsfwcyoamaker.cotdr.presentation.model.ExperimentalBrandOption
import com.nsfwcyoamaker.cotdr.presentation.model.ExperimentalBrandState
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.ExperimentalBrandsSelectionAction
import org.jetbrains.compose.ui.tooling.preview.Preview

fun LazyListScope.MainPage4(
    brandStateProvider: @Composable (BrandOption) -> BrandState,
    onBrandAction: (BrandsSelectionAction) -> Unit,
    experimentalBrandStateProvider: @Composable (ExperimentalBrandOption) -> ExperimentalBrandState,
    onExperimentalBrandAction: (ExperimentalBrandsSelectionAction) -> Unit
) {
    item(
        key = "HistoryTitle",
        contentType = "HistoryTitle"
    ) { HistoryTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "HistoryDescription",
        contentType = "HistoryDescription"
    ) { HistoryDescription() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "BrandsTitle",
        contentType = "BrandsTitle"
    ) { BrandsTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "BrandsDescription",
        contentType = "BrandsDescription"
    ) { BrandsDescription() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    BrandsGridItem(
        brandStateProvider,
        onBrandAction,
    )

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "BrandsInterlude",
        contentType = "BrandsInterlude"
    ) { BrandsInterlude() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    ExperimentalBrandsGridItem(
        experimentalBrandStateProvider,
        onExperimentalBrandAction,
    )

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "BrandsExtra",
        contentType = "BrandsExtra"
    ) { BrandsExtra() }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun MainPage4Preview() {
    AppScope {
        MainScreenList {
            MainPage4(
                { option -> BrandState(option) },
                {},
                { option -> ExperimentalBrandState(option) },
                {},
            )
        }
    }
}
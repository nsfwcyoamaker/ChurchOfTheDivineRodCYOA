package com.nsfwcyoamaker.cotdr.presentation.components.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.sections.covenants.CovenantsDescription
import com.nsfwcyoamaker.cotdr.presentation.components.sections.covenants.CovenantsGridItem
import com.nsfwcyoamaker.cotdr.presentation.components.sections.covenants.CovenantsTitle
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionState
import org.jetbrains.compose.ui.tooling.preview.Preview

fun LazyListScope.MainPage3(
    covenantState: CovenantsSelectionState,
    onCovenantsAction: (CovenantsSelectionAction) -> Unit
) {
    item(
        key = "CovenantsTitle",
        contentType = "CovenantsTitle"
    ) { CovenantsTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "CovenantsDescription",
        contentType = "CovenantsDescription"
    ) { CovenantsDescription() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    CovenantsGridItem(
        covenantState,
        onCovenantsAction,
    )

    item { Spacer(modifier = Modifier.height(12.dp)) }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun MainPage3Preview() {
    AppScope {
        MainScreenList {
            MainPage3(
                CovenantsSelectionState(),
                {},
            )
        }
    }
}
package com.nsfwcyoamaker.cotdr.presentation.components.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications.BodilyModificationsDescription
import com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications.BodilyModificationsExtra
import com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications.BodilyModificationsGridItem
import com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications.BodilyModificationsTitle
import com.nsfwcyoamaker.cotdr.presentation.components.sections.fervor.FervorDescription
import com.nsfwcyoamaker.cotdr.presentation.components.sections.fervor.FervorTitle
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationOption
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationState
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionAction
import org.jetbrains.compose.ui.tooling.preview.Preview

fun LazyListScope.MainPage2(
    itemStateProvider: @Composable (BodilyModificationOption) -> BodilyModificationState,
    onBodilyModificationAction: (BodilyModificationsSelectionAction) -> Unit
) {
    item(
        key = "FervorTitle",
        contentType = "FervorTitle"
    ) { FervorTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "FervorDescription",
        contentType = "FervorDescription"
    ) { FervorDescription() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "BodilyModificationsTitle",
        contentType = "BodilyModificationsTitle"
    ) { BodilyModificationsTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "BodilyModificationsDescription",
        contentType = "BodilyModificationsDescription"
    ) { BodilyModificationsDescription() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    BodilyModificationsGridItem(
        itemStateProvider,
        onBodilyModificationAction,
    )

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "BodilyModificationsExtra",
        contentType = "BodilyModificationsExtra"
    ) { BodilyModificationsExtra() }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun MainPage2Preview() {
    AppScope {
        MainScreenList {
            MainPage2(
                itemStateProvider = { option -> BodilyModificationState(option) },
                onBodilyModificationAction = {},
            )
        }
    }
}
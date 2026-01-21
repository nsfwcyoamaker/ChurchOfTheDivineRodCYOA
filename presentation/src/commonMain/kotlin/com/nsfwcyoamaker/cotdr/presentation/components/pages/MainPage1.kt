package com.nsfwcyoamaker.cotdr.presentation.components.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.main.MainIntroduction
import com.nsfwcyoamaker.cotdr.presentation.components.main.MainTitle
import com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction.*
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionState
import org.jetbrains.compose.ui.tooling.preview.Preview

fun LazyListScope.MainPage1(
    consortsState: ConsortsSelectionState,
    onConsortsAction: (ConsortsSelectionAction) -> Unit,
) {
    item(
        key = "MainTitle",
        contentType = "MainTitle"
    ) { MainTitle() }

    item { Spacer(modifier = Modifier.height(24.dp)) }

    item(
        key = "MainIntroduction",
        contentType = "MainIntroduction"
    ) { MainIntroduction() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "PriestessesIntroductionTitle",
        contentType = "PriestessesIntroductionTitle"
    ) { PriestessesIntroductionTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "PriestessIntroductionDescription",
        contentType = "PriestessIntroductionDescription"
    ) { PriestessIntroductionDescription() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    PriestessesIntroductionGridItem(
        consortsState,
        onConsortsAction,
    )

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "PriestessIntroductionExtra1",
        contentType = "PriestessIntroductionExtra1"
    ) { PriestessIntroductionExtra1() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "PriestessIntroductionInterlude",
        contentType = "PriestessIntroductionInterlude"
    ) { PriestessIntroductionInterlude() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "PriestessIntroductionExtra2",
        contentType = "PriestessIntroductionExtra2"
    ) { PriestessIntroductionExtra2() }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun MainPage1Preview() {
    AppScope {
        MainScreenList {
            MainPage1(
                consortsState = ConsortsSelectionState(),
                onConsortsAction = {},
            )
        }
    }
}
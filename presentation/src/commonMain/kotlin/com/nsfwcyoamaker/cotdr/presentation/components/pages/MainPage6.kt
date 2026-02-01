package com.nsfwcyoamaker.cotdr.presentation.components.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.sections.church_appeal.ChurchAppealDescription
import com.nsfwcyoamaker.cotdr.presentation.components.sections.church_appeal.ChurchAppealTitle
import com.nsfwcyoamaker.cotdr.presentation.components.sections.waifs.WaifsIntro
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import org.jetbrains.compose.ui.tooling.preview.Preview

fun LazyListScope.MainPage6() {
    item(
        key = "WaifsIntro",
        contentType = "WaifsIntro",
    ) { WaifsIntro() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "ChurchAppealTitle",
        contentType = "ChurchAppealTitle",
    ) { ChurchAppealTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "ChurchAppealDescription",
        contentType = "ChurchAppealDescription",
    ) { ChurchAppealDescription() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    //todo
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun MainPage6Preview() {
    AppScope {
        MainScreenList {
            MainPage6()
        }
    }
}
package com.nsfwcyoamaker.cotdr.presentation.components.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications.BodilyModificationsDescription
import com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications.BodilyModificationsTitle
import com.nsfwcyoamaker.cotdr.presentation.components.sections.fervor.FervorDescription
import com.nsfwcyoamaker.cotdr.presentation.components.sections.fervor.FervorTitle
import org.jetbrains.compose.ui.tooling.preview.Preview

fun LazyListScope.MainPage2(
    itemsModifier: Modifier = Modifier,
) {
    item(
        key = "FervorTitle",
        contentType = "FervorTitle"
    ) { FervorTitle(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(6.dp)) }

    item(
        key = "FervorDescription",
        contentType = "FervorDescription"
    ) { FervorDescription(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(6.dp)) }

    item(
        key = "BodilyModificationsTitle",
        contentType = "BodilyModificationsTitle"
    ) { BodilyModificationsTitle(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(6.dp)) }

    item(
        key = "BodilyModificationsDescription",
        contentType = "BodilyModificationsDescription"
    ) { BodilyModificationsDescription(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(6.dp)) }

    // todo
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun MainPage1Preview() {
    AppScope {
        val itemsModifier = Modifier
            .fillMaxWidth(0.95f)
            .padding(horizontal = 80.dp)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            item { Spacer(modifier = Modifier.height(60.dp)) }
            MainPage2(itemsModifier)
            item { Spacer(modifier = Modifier.height(260.dp)) }
        }
    }
}
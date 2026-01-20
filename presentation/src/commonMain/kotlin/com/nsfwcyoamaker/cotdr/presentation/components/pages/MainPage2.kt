package com.nsfwcyoamaker.cotdr.presentation.components.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.PreviewScope
import com.nsfwcyoamaker.cotdr.presentation.components.sections.fervor.FervorDescription
import com.nsfwcyoamaker.cotdr.presentation.components.sections.fervor.FervorTitle
import org.jetbrains.compose.ui.tooling.preview.Preview

fun LazyListScope.MainPage2(
    itemsModifier: Modifier = Modifier,
) {
    item { FervorTitle(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(6.dp)) }

    item { FervorDescription(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(6.dp)) }

    // todo
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun MainPage1Preview() {
    PreviewScope {
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
package com.nsfwcyoamaker.cotdr.presentation.components.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.main.MainIntroduction
import com.nsfwcyoamaker.cotdr.presentation.components.main.MainTitle
import com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction.*
import org.jetbrains.compose.ui.tooling.preview.Preview

fun LazyListScope.MainPage1(
    itemsModifier: Modifier = Modifier,
) {
    item { MainTitle(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(16.dp)) }

    item { MainIntroduction(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(4.dp)) }

    item { PriestessesIntroductionTitle(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(4.dp)) }

    item { PriestessIntroductionDescription(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(6.dp)) }

    item { PriestessesIntroductionGrid(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(6.dp)) }

    item { PriestessIntroductionExtra1(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(6.dp)) }

    item { PriestessIntroductionInterlude(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(6.dp)) }

    item { PriestessIntroductionExtra2(modifier = itemsModifier) }
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
            MainPage1(itemsModifier)
            item { Spacer(modifier = Modifier.height(260.dp)) }
        }
    }
}
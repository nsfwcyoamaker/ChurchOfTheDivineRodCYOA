package com.nsfwcyoamaker.cotdr.presentation.components.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.components.main.MainIntroduction
import com.nsfwcyoamaker.cotdr.presentation.components.main.MainTitle
import com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction.*

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
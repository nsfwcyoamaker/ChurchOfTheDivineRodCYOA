package com.nsfwcyoamaker.cotdr.presentation.components.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.components.sections.fervor.FervorDescription
import com.nsfwcyoamaker.cotdr.presentation.components.sections.fervor.FervorTitle

fun LazyListScope.MainPage2(
    itemsModifier: Modifier = Modifier,
) {
    item { FervorTitle(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(6.dp)) }

    item { FervorDescription(modifier = itemsModifier) }

    item { Spacer(modifier = Modifier.height(6.dp)) }

    // todo
}
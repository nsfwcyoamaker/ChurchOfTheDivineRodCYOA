package com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroduction
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.PriestessesIntroductionGridItem(
    itemsModifier: Modifier = Modifier,
) {
    val priestessesByRow = PriestessIntroduction.entries.chunked(3)

    priestessesByRow.forEachIndexed { index, priestessesRow ->
        item(
            key = "priestesses_introduction_row_$index",
            contentType = "priestesses_introduction_row"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = itemsModifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                priestessesRow.forEach { priestess ->
                    var isSelected by remember { mutableStateOf(false) }

                    SelectablePriestessCard(
                        title = priestess.title,
                        image = priestess.image,
                        description = priestess.description,
                        isSelected = isSelected,
                        onSelected = { isSelected = !isSelected },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                    )
                }
            }
        }

        if(index < (priestessesByRow.size - 1)) {
            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun PriestessesIntroductionGridItemPreview() {
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
            PriestessesIntroductionGridItem(itemsModifier)
            item { Spacer(modifier = Modifier.height(260.dp)) }
        }
    }
}
package com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationOption
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.BodilyModificationsGridItem() {
    val chinked = BodilyModificationOption.entries.chunked(3)
    chinked.forEachIndexed { index, bodilyModificationsRow ->
        item(
            key = "bodily_modifications_row_$index",
            contentType = "bodily_modifications_row"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                bodilyModificationsRow.forEach { bodilyModification ->
                    BodilyModificationCard(
                        bodilyModification = bodilyModification,
                        isClickable = false,
                        isSelected = false,
                        onSelected = { /**/ },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                    )
                }
            }
        }

        if(index < (chinked.size - 1)) {
            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun BodilyModificationsGridItemPreview() {
    AppScope {
        MainScreenList {
            BodilyModificationsGridItem()
        }
    }
}
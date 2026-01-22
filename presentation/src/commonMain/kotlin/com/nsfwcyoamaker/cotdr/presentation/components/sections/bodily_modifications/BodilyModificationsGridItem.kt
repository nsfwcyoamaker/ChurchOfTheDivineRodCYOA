package com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationExtraState
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionState
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.BodilyModificationsGridItem(
    bodilyModificationsState: BodilyModificationsSelectionState,
    onBodilyModificationAction: (BodilyModificationsSelectionAction) -> Unit
) {
    bodilyModificationsState.bodilyModifications.forEachIndexed { index, bodilyModificationsRow ->
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
                when(bodilyModificationsRow) {
                    is BodilyModificationsSelectionState.Row.ChoicesRow -> {
                        bodilyModificationsRow.choices.forEach { bodilyModification ->
                            BodilyModificationCard(
                                state = bodilyModification,
                                onAction = onBodilyModificationAction,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight(),
                            )
                        }
                    }

                    is BodilyModificationsSelectionState.Row.ExtrasRow -> {
                        bodilyModificationsRow.extras.forEach { bodilyModificationExtra ->
                            when(bodilyModificationExtra) {
                                is BodilyModificationExtraState.EmptyOption -> {
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxHeight(),
                                    )
                                }
                                is BodilyModificationExtraState.MultiBuyOption -> {
                                    BodilyModificationMultiBuyCard(
                                        state = bodilyModificationExtra,
                                        onAction = onBodilyModificationAction,
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxHeight(),
                                    )
                                }
                                is BodilyModificationExtraState.UpgradeOption -> {
                                    BodilyModificationUpgradeCard(
                                        state = bodilyModificationExtra,
                                        onAction = onBodilyModificationAction,
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxHeight(),
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        if(index < (bodilyModificationsState.bodilyModifications.size - 1)) {
            if(bodilyModificationsState.bodilyModifications[index + 1] is BodilyModificationsSelectionState.Row.ChoicesRow) {
                item { Spacer(modifier = Modifier.height(24.dp)) }
            } else {
                item { Spacer(modifier = Modifier.height(8.dp)) }
            }
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
            BodilyModificationsGridItem(
                bodilyModificationsState = BodilyModificationsSelectionState(),
                onBodilyModificationAction = {},
            )
        }
    }
}
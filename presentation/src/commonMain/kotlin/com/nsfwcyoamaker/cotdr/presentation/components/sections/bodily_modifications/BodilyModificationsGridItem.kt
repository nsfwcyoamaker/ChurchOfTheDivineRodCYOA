package com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.ChoicesGrid
import com.nsfwcyoamaker.cotdr.presentation.model.UiControlState
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionState
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action.BodilyModificationClickedAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action.DecreaseBodilyModificationBuyTimesAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action.IncreaseBodilyModificationBuyTimesAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action.UpgradeBodilyModificationClickedAction
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.BodilyModificationsGridItem(
    bodilyModificationsState: BodilyModificationsSelectionState,
    onBodilyModificationAction: (BodilyModificationsSelectionAction) -> Unit
) {
    ChoicesGrid(
        items = bodilyModificationsState.items,
        columns = 3,
        key = "bodily_modifications_row",
        contentType = "bodily_modifications_row",
        itemContent = { item ->
            BodilyModificationCard(
                state = item,
                onSelected = { onBodilyModificationAction(BodilyModificationClickedAction(item.option.choice)) },
            )
        },
        extraContent = { item ->
            when (val controlState = item.control) {
                is UiControlState.MultiBuy -> {
                    BodilyModificationMultiBuyCard(
                        state = controlState,
                        onBuyLess = { onBodilyModificationAction(DecreaseBodilyModificationBuyTimesAction(item.option.choice)) },
                        onBuyMore = { onBodilyModificationAction(IncreaseBodilyModificationBuyTimesAction(item.option.choice)) },
                        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                    )
                }
                is UiControlState.Upgrade -> {
                    BodilyModificationUpgradeCard(
                        state = controlState,
                        onUpgrade = { onBodilyModificationAction(UpgradeBodilyModificationClickedAction(item.option.choice)) },
                        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                    )
                }
                is UiControlState.None -> {}
            }
        }
    )
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
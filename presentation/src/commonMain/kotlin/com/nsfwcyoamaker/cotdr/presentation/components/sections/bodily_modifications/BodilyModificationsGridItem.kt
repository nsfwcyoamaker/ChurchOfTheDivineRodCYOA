package com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.ChoicesGrid
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationOption
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationState
import com.nsfwcyoamaker.cotdr.presentation.model.UiControlState
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action.BodilyModificationClickedAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action.DecreaseBodilyModificationBuyTimesAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action.IncreaseBodilyModificationBuyTimesAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action.UpgradeBodilyModificationClickedAction
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.BodilyModificationsGridItem(
    itemStateProvider: @Composable (BodilyModificationOption) -> BodilyModificationState,
    onBodilyModificationAction: (BodilyModificationsSelectionAction) -> Unit
) {
    ChoicesGrid(
        items = BodilyModificationOption.all,
        columns = 3,
        key = "bodily_modifications_row",
        contentType = "bodily_modifications_row",
        itemContent = { option ->
            val state = itemStateProvider(option)
            BodilyModificationCard(
                state = state,
                onSelected = { onBodilyModificationAction(BodilyModificationClickedAction(option.choice)) },
            )
        },
        extraContent = { option ->
            val state = itemStateProvider(option)
            when (val controlState = state.control) {
                is UiControlState.MultiBuy -> {
                    BodilyModificationMultiBuyCard(
                        state = controlState,
                        onBuyLess = { onBodilyModificationAction(DecreaseBodilyModificationBuyTimesAction(option.choice)) },
                        onBuyMore = { onBodilyModificationAction(IncreaseBodilyModificationBuyTimesAction(option.choice)) },
                        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                    )
                }
                is UiControlState.Upgrade -> {
                    BodilyModificationUpgradeCard(
                        state = controlState,
                        onUpgrade = { onBodilyModificationAction(UpgradeBodilyModificationClickedAction(option.choice)) },
                        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                    )
                }
                else -> {}
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
                itemStateProvider = { option -> BodilyModificationState(option) },
                onBodilyModificationAction = {},
            )
        }
    }
}
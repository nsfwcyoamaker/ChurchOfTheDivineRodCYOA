package com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.SelectableCard
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationExtraState
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationOption
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action.UpgradeBodilyModificationClickedAction
import com.nsfwcyoamaker.cotdr.presentation.theme.headerTextStyle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.mod_make_permanent
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BodilyModificationUpgradeCard(
    state: BodilyModificationExtraState.UpgradeOption,
    onAction: (BodilyModificationsSelectionAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = state.upgradeSelected,
        isClickable = state.upgradeEnabled,
        onSelected = { onAction(UpgradeBodilyModificationClickedAction(state.bodilyModificationOption.bodilyModification)) },
        cornerBracketsVisible = false,
        modifier = modifier
            .alpha(if (state.upgradeEnabled) 1f else 0.3f),
    ) {
        Text(
            text = rememberRichTextResource(state.upgradeText),
            style = headerTextStyle,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun BodilyModificationCardPreview() {
    AppScope {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            BodilyModificationUpgradeCard(
                state = BodilyModificationExtraState.UpgradeOption(
                    BodilyModificationOption.Towering,
                    Res.string.mod_make_permanent,
                ),
                onAction = {},
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .wrapContentHeight(),
            )
        }
    }
}
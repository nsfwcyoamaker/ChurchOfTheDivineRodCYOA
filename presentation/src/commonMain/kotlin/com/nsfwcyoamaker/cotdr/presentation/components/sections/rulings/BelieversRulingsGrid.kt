package com.nsfwcyoamaker.cotdr.presentation.components.sections.rulings

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.model.BelieversRulingOption
import com.nsfwcyoamaker.cotdr.presentation.model.RulingOption
import com.nsfwcyoamaker.cotdr.presentation.model.RulingState
import com.nsfwcyoamaker.cotdr.presentation.screens.rulings.RulingsSelectionAction

@Composable
fun BelieversRulingsGrid(
    rulingStateProvider: @Composable (RulingOption.Option) -> RulingState.RulingOptionState,
    onRulingAction: (RulingsSelectionAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    RulingsGrid(
        rulings = BelieversRulingOption.entries,
        rulingStateProvider = rulingStateProvider,
        onRulingAction = onRulingAction,
        modifier = modifier,
    )
}
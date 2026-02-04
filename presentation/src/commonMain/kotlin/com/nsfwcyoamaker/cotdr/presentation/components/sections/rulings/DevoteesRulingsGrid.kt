package com.nsfwcyoamaker.cotdr.presentation.components.sections.rulings

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.model.DevoteesRulingOption
import com.nsfwcyoamaker.cotdr.presentation.model.RulingOption
import com.nsfwcyoamaker.cotdr.presentation.model.RulingState
import com.nsfwcyoamaker.cotdr.presentation.screens.rulings.RulingsSelectionAction

@Composable
fun DevoteesRulingsGrid(
    rulingStateProvider: @Composable (RulingOption.Option) -> RulingState.RulingOptionState,
    onRulingAction: (RulingsSelectionAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    RulingsGrid(
        rulings = DevoteesRulingOption.entries,
        rulingStateProvider = rulingStateProvider,
        onRulingAction = onRulingAction,
        modifier = modifier,
    )
}
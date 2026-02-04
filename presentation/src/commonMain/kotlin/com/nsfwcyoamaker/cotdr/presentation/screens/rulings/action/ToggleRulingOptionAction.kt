package com.nsfwcyoamaker.cotdr.presentation.screens.rulings.action

import com.nsfwcyoamaker.cotdr.domain.model.Ruling
import com.nsfwcyoamaker.cotdr.presentation.screens.rulings.RulingsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.rulings.RulingsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.rulings.RulingsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

class ToggleRulingOptionAction(
    val option: Ruling.RulingOption,
): RulingsSelectionAction {
    override suspend fun execute(
        dependencies: RulingsSelectionActionDependencies,
        scope: ActionScope<RulingsSelectionState, Nothing>
    ) {
        dependencies.toggleChoiceAlternativeUseCase(option)
    }
}
package com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal.action

import com.nsfwcyoamaker.cotdr.domain.model.ChurchAppeal
import com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal.ChurchAppealSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal.ChurchAppealSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal.ChurchAppealSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

data class ToggleChurchAppealAction(
    val churchAppeal: ChurchAppeal,
): ChurchAppealSelectionAction {
    override suspend fun execute(
        dependencies: ChurchAppealSelectionActionDependencies,
        scope: ActionScope<ChurchAppealSelectionState, Nothing>
    ) {
        dependencies.toggleChoiceUseCase(churchAppeal)
    }
}
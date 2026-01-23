package com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.action

import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroductionOption
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

data class TogglePriestessAction(
    val priestessOption: PriestessIntroductionOption,
): ConsortsSelectionAction {
    override suspend fun execute(
        dependencies: ConsortsSelectionActionDependencies,
        scope: ActionScope<ConsortsSelectionState, Nothing>
    ) {
        dependencies.toggleChoiceUseCase(priestessOption.choice)
    }
}
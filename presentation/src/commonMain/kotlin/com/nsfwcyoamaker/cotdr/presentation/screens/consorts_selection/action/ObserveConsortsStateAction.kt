package com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.action

import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroductionOption
import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroductionState
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

data object ObserveConsortsStateAction: ConsortsSelectionAction {
    override suspend fun execute(
        dependencies: ConsortsSelectionActionDependencies,
        scope: ActionScope<ConsortsSelectionState, Nothing>
    ) {
        dependencies.getCurrentConsortsFlowUseCase().collect { repoData ->
            scope.setState {
                ConsortsSelectionState(
                    PriestessIntroductionOption.entries.map {
                        PriestessIntroductionState(
                            priestessIntroductionOption = it,
                            isClickable = it != PriestessIntroductionOption.Consorts,
                            isSelected = it.priestess in repoData,
                        )
                    }.chunked(3)
                )
            }
        }
    }
}
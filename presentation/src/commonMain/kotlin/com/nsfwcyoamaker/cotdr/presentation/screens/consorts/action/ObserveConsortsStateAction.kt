package com.nsfwcyoamaker.cotdr.presentation.screens.consorts.action

import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroductionOption
import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroductionState
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts.ConsortsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts.ConsortsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts.ConsortsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

data object ObserveConsortsStateAction: ConsortsSelectionAction {
    override suspend fun execute(
        dependencies: ConsortsSelectionActionDependencies,
        scope: ActionScope<ConsortsSelectionState, Nothing>
    ) {
        dependencies.getCurrentConsortsFlowUseCase().collect { repoData ->
            scope.setState {
                ConsortsSelectionState(
                    PriestessIntroductionOption.entries.associateWith {
                        PriestessIntroductionState(
                            option = it,
                            isSelected = it.choice in repoData,
                        )
                    }
                )
            }
        }
    }
}
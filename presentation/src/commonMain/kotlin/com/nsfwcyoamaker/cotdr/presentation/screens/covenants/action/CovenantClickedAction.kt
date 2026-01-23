package com.nsfwcyoamaker.cotdr.presentation.screens.covenants.action

import com.nsfwcyoamaker.cotdr.domain.model.Covenant
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

data class CovenantClickedAction(val covenant: Covenant): CovenantsSelectionAction {
    override suspend fun execute(
        dependencies: CovenantsSelectionActionDependencies,
        scope: ActionScope<CovenantsSelectionState, Nothing>
    ) {
        dependencies.toggleChoiceUseCase(covenant)
    }
}
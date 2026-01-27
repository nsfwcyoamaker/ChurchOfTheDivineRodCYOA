package com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action

import com.nsfwcyoamaker.cotdr.domain.engine.model.UpgradableChoice
import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

data class UpgradeBodilyModificationClickedAction(val bodilyModification: BodilyModification): BodilyModificationsSelectionAction {
    override suspend fun execute(
        dependencies: BodilyModificationsSelectionActionDependencies,
        scope: ActionScope<BodilyModificationsSelectionState, Nothing>
    ) {
        (bodilyModification as? UpgradableChoice)?.let {
            dependencies.toggleChoiceUpgradeUseCase(it)
        }
    }
}
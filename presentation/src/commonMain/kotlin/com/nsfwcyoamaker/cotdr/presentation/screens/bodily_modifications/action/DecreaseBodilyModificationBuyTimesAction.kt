package com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action

import com.nsfwcyoamaker.cotdr.domain.engine.model.MultibuyChoice
import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

data class DecreaseBodilyModificationBuyTimesAction(val bodilyModification: BodilyModification) : BodilyModificationsSelectionAction {
    override suspend fun execute(
        dependencies: BodilyModificationsSelectionActionDependencies,
        scope: ActionScope<BodilyModificationsSelectionState, Nothing>
    ) {
        (bodilyModification as? MultibuyChoice)?.let {
            dependencies.decreaseChoiceBuyTimesUseCase(it)
        }
    }
}
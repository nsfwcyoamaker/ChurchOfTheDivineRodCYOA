package com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications

import com.nsfwcyoamaker.cotdr.domain.usecase.*
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action.ObserveBodilyModificationsSelectionStateAction
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ToadViewModel
import kotlinx.coroutines.CoroutineScope

class BodilyModificationsSelectionViewModel(
    private val scope: CoroutineScope,
    private val getCurrentChoicesFlowUseCase: GetCurrentChoicesFlowUseCase,
    private val bodilyModificationClickedUseCase: BodilyModificationClickedUseCase,
    private val upgradeBodilyModificationClickedUseCase: UpgradeBodilyModificationClickedUseCase,
    private val increaseBodilyModificationBuyTimesUseCase: IncreaseBodilyModificationBuyTimesUseCase,
    private val decreaseBodilyModificationBuyTimesUseCase: DecreaseBodilyModificationBuyTimesUseCase,
): ToadViewModel<BodilyModificationsSelectionState, Nothing>(
    initialState = BodilyModificationsSelectionState(),
    scope = scope,
) {
    override val dependencies = BodilyModificationsSelectionActionDependencies(
        scope,
        getCurrentChoicesFlowUseCase,
        bodilyModificationClickedUseCase,
        upgradeBodilyModificationClickedUseCase,
        increaseBodilyModificationBuyTimesUseCase,
        decreaseBodilyModificationBuyTimesUseCase,
    )

    init {
        dispatch(ObserveBodilyModificationsSelectionStateAction)
    }

    fun runAction(action: BodilyModificationsSelectionAction) {
        dispatch(action)
    }
}
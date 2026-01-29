package com.nsfwcyoamaker.cotdr.domain.engine.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.logic.GameStateManager
import com.nsfwcyoamaker.cotdr.domain.engine.model.AlternativeChoice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState

class ToggleChoiceAlternativeUseCase(
    private val gameStateManager: GameStateManager
) {
    operator fun invoke(alternative: AlternativeChoice.Alternative) {
        gameStateManager.updateChoice<AlternativeChoice, ChoiceState.Alternative>(alternative.choice) { currentState ->
            if(currentState?.selected == alternative) {
                null
            } else {
                ChoiceState.Alternative(
                    selected = alternative,
                )
            }
        }
    }
}
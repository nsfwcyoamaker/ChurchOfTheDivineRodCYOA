package com.nsfwcyoamaker.cotdr.domain.engine.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.logic.GameStateManager
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice

class DecreaseChoiceBuyTimesUseCase(
    private val gameStateManager: GameStateManager
) {
    operator fun invoke(choice: Choice) {
        gameStateManager.updateChoice(choice) { s ->
            if(s.quantity == 1) {
                null
            } else {
                s.copy(isSelected = true, quantity = s.quantity - 1)
            }
        }
    }
}
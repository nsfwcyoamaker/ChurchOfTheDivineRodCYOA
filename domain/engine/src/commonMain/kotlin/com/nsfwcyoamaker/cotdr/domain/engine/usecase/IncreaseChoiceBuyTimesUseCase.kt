package com.nsfwcyoamaker.cotdr.domain.engine.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.logic.GameStateManager
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice

class IncreaseChoiceBuyTimesUseCase(
    private val gameStateManager: GameStateManager
) {
    operator fun invoke(choice: Choice) {
        gameStateManager.updateChoice(choice) { s ->
            s.copy(isSelected = true, quantity = s.quantity + 1)
        }
    }
}
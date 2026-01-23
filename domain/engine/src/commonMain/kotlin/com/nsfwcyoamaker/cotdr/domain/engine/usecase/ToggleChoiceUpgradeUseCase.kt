package com.nsfwcyoamaker.cotdr.domain.engine.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.logic.GameStateManager
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice

class ToggleChoiceUpgradeUseCase(
    private val gameStateManager: GameStateManager
) {
    operator fun invoke(choice: Choice) {
        gameStateManager.updateChoice(choice) { currentState ->
            currentState.copy(
                upgraded = !currentState.upgraded,
            )
        }
    }
}
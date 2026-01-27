package com.nsfwcyoamaker.cotdr.domain.engine.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.logic.GameStateManager
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.model.UpgradableChoice

class ToggleChoiceUpgradeUseCase(
    private val gameStateManager: GameStateManager
) {
    operator fun invoke(choice: UpgradableChoice) {
        gameStateManager.updateChoice<UpgradableChoice, ChoiceState.Upgradable>(choice) { currentState ->
            ChoiceState.Upgradable(
                upgraded = currentState?.upgraded?.not() ?: true,
            )
        }
    }
}
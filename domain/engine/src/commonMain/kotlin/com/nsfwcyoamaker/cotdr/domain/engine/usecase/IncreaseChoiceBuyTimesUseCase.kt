package com.nsfwcyoamaker.cotdr.domain.engine.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.logic.GameStateManager
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.model.MultibuyChoice

class IncreaseChoiceBuyTimesUseCase(
    private val gameStateManager: GameStateManager
) {
    operator fun invoke(choice: MultibuyChoice) {
        gameStateManager.updateChoice<MultibuyChoice, ChoiceState.MultiBuy>(choice) { s ->
            ChoiceState.MultiBuy(
                quantity = (s?.quantity ?: 0) + 1
            )
        }
    }
}
package com.nsfwcyoamaker.cotdr.domain.usecase

import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification
import com.nsfwcyoamaker.cotdr.domain.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.repository.GameStateRepository
import com.nsfwcyoamaker.cotdr.domain.rules.CostStrategy

class DecreaseBodilyModificationBuyTimesUseCase(
    private val repository: GameStateRepository,
) {
    operator fun invoke(bodilyModification: BodilyModification) {
        if(bodilyModification.strategy !is CostStrategy.MultiBuy) return

        val allChoices = repository.selectedChoicesStateFlow.value

        val state = allChoices[bodilyModification] ?: return
        val ctx = CalculationContext(allChoices)

        val requirementsMet = bodilyModification.requirements(ctx)
        if(!requirementsMet) return

        if(state.quantity == 1) {
            repository.setChoiceState(bodilyModification, null)
        } else {
            repository.setChoiceState(
                bodilyModification,
                ChoiceState(
                    isSelected = true,
                    quantity = state.quantity - 1,
                    upgraded = false,
                )
            )
        }
    }
}
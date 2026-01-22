package com.nsfwcyoamaker.cotdr.domain.usecase

import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification
import com.nsfwcyoamaker.cotdr.domain.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.repository.GameStateRepository

class BodilyModificationClickedUseCase(
    private val repository: GameStateRepository,
) {
    operator fun invoke(bodilyModification: BodilyModification) {
        val allChoices = repository.selectedChoicesStateFlow.value

        val state = allChoices[bodilyModification]

        if(state != null) {
            repository.setChoiceState(bodilyModification, null)
            return
        }

        val ctx = CalculationContext(allChoices)
        val requirementsMet = bodilyModification.requirements(ctx)

        if(!requirementsMet) {
            repository.setChoiceState(bodilyModification, null)
            return
        }

        repository.setChoiceState(
            bodilyModification,
            ChoiceState(
                isSelected = true,
                quantity = 1,
                upgraded = false,
            )
        )
    }
}
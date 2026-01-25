package com.nsfwcyoamaker.cotdr.domain.engine.logic

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.repository.ChoiceRegistry

class GameStateValidator(
    private val choiceRegistry: ChoiceRegistry
) {
    fun sanitize(
        currentSelections: Map<Choice, ChoiceState>
    ): Map<Choice, ChoiceState> {
        val allChoices = choiceRegistry.getAllChoices()

        var hasChanged = false
        
        val context = CalculationContext(currentSelections)
        val newSelections = currentSelections.toMutableMap()

        allChoices.forEach { choice ->
            val state = currentSelections[choice] ?: return@forEach

            if (!choice.requirements(context)) {
                newSelections.remove(choice)
                hasChanged = true
                return@forEach
            }

            val validatedState = choice.strategy.validate(state, context)

            if (validatedState != state) {
                newSelections[choice] = validatedState
                hasChanged = true
            }
        }

        return if (hasChanged) {
            sanitize(newSelections)
        } else {
            newSelections
        }
    }
}
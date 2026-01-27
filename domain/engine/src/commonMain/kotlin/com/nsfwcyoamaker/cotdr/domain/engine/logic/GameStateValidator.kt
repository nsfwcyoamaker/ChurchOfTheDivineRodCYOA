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
            val state = choice.getValidState(context)

            if (context.selections[choice] != state) {
                if(state == null) {
                    newSelections.remove(choice)
                } else {
                    newSelections[choice] = state
                }
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
package com.nsfwcyoamaker.cotdr.domain.engine.logic

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.repository.ChoiceRegistry
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GlobalSelectionRuleRegistry

class GameStateValidator(
    private val choiceRegistry: ChoiceRegistry,
    private val selectionRulesRegistry: GlobalSelectionRuleRegistry,
) {
    fun sanitize(
        currentSelections: Map<Choice, ChoiceState>,
        previousSelections: Map<Choice, ChoiceState>,
    ): Map<Choice, ChoiceState> {
        val allChoices = choiceRegistry.getAllChoices()
        val allRules = selectionRulesRegistry.getRules()

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

        allRules.forEach { rule ->
            val ruleChanged = rule.apply(newSelections, previousSelections)
            if (ruleChanged) {
                hasChanged = true
            }
        }

        return if (hasChanged) {
            sanitize(newSelections, previousSelections)
        } else {
            newSelections
        }
    }
}
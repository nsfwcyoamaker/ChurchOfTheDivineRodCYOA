package com.nsfwcyoamaker.cotdr.domain.rules

import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.rules.GlobalSelectionRule
import com.nsfwcyoamaker.cotdr.domain.model.Contract
import com.nsfwcyoamaker.cotdr.domain.model.ContractConduct

object AutoSelectConductRule: GlobalSelectionRule {
    override fun apply(
        current: MutableMap<Choice, ChoiceState>,
        previous: Map<Choice, ChoiceState>
    ): Boolean {
        var hasChanged = false

        Contract.entries.forEach { contract ->
            val conduct = ContractConduct.all.firstOrNull { it.targetContract == contract }
                ?: return@forEach

            val contractSelected = current.containsKey(contract)
            val conductSelected = current.containsKey(conduct)
            val conductWasSelected = previous.containsKey(conduct)

            if (contractSelected && !conductSelected) {
                if (conductWasSelected) {
                    current.remove(contract)
                    hasChanged = true
                } else {
                    current[conduct] = conduct.getDefaultState()
                    hasChanged = true
                }
            }
        }

        return hasChanged
    }
}
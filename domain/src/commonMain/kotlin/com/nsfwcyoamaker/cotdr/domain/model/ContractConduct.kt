package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.AlternativeChoice
import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.model.CotdrCurrency.Fervor

data class ContractConduct(
    val targetContract: Contract
): AlternativeChoice {

    data class Option(
        override val choice: ContractConduct,
        val type: ConductType
    ) : AlternativeChoice.Alternative {
        override val cost: Resources
            get() = Resources(Fervor, type.fervorChange)
    }

    override val alternatives: List<Option> = ConductType.entries.map { Option(this, it) }

    override fun getDefaultState(): ChoiceState.Alternative {
        return ChoiceState.Alternative(Option(this, ConductType.Aligned))
    }
    override fun requirementsMet(ctx: CalculationContext): Boolean {
        return targetContract.getValidState(ctx) != null
    }

    companion object {
        val all = Contract.entries.map { ContractConduct(it) }
    }
}
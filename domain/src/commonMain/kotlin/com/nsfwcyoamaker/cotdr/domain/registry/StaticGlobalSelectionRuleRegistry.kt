package com.nsfwcyoamaker.cotdr.domain.registry

import com.nsfwcyoamaker.cotdr.domain.engine.repository.GlobalSelectionRuleRegistry
import com.nsfwcyoamaker.cotdr.domain.engine.rules.GlobalSelectionRule
import com.nsfwcyoamaker.cotdr.domain.model.ChurchAppeal
import com.nsfwcyoamaker.cotdr.domain.rules.AutoSelectConductRule
import com.nsfwcyoamaker.cotdr.domain.rules.SingleSelectionInGroupRule

object StaticGlobalSelectionRuleRegistry : GlobalSelectionRuleRegistry {
    private val rules: List<GlobalSelectionRule> = listOf(
        AutoSelectConductRule,
        SingleSelectionInGroupRule { it.keys.filterIsInstance<ChurchAppeal>().toSet() },
    )

    override fun getRules(): List<GlobalSelectionRule> = rules
}
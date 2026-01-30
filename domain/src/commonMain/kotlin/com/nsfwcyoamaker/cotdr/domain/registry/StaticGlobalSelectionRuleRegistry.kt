package com.nsfwcyoamaker.cotdr.domain.registry

import com.nsfwcyoamaker.cotdr.domain.engine.repository.GlobalSelectionRuleRegistry
import com.nsfwcyoamaker.cotdr.domain.engine.rules.GlobalSelectionRule
import com.nsfwcyoamaker.cotdr.domain.rules.AutoSelectConductRule

object StaticGlobalSelectionRuleRegistry : GlobalSelectionRuleRegistry {
    private val rules: List<GlobalSelectionRule> = listOf(
        AutoSelectConductRule,
    )

    override fun getRules(): List<GlobalSelectionRule> = rules
}
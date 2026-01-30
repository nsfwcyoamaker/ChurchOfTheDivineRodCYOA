package com.nsfwcyoamaker.cotdr.domain.registry

import com.nsfwcyoamaker.cotdr.domain.engine.repository.GlobalScoreRuleRegistry
import com.nsfwcyoamaker.cotdr.domain.engine.rules.GlobalScoreRule
import com.nsfwcyoamaker.cotdr.domain.rules.BrandsScalingRule
import com.nsfwcyoamaker.cotdr.domain.rules.PriestessesScalingRule

object StaticGlobalScoreRuleRegistry : GlobalScoreRuleRegistry {
    private val rules: List<GlobalScoreRule> = listOf(
        PriestessesScalingRule,
        BrandsScalingRule,
    )

    override fun getScoreRules(): List<GlobalScoreRule> = rules
}
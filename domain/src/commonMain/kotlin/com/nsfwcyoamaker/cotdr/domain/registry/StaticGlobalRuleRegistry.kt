package com.nsfwcyoamaker.cotdr.domain.registry

import com.nsfwcyoamaker.cotdr.domain.engine.repository.GlobalRuleRegistry
import com.nsfwcyoamaker.cotdr.domain.engine.rules.GlobalScoreRule
import com.nsfwcyoamaker.cotdr.domain.rules.PriestessScalingRule

object StaticGlobalRuleRegistry : GlobalRuleRegistry {
    private val rules: List<GlobalScoreRule> = listOf(
        PriestessScalingRule,
    )

    override fun getRules(): List<GlobalScoreRule> = rules
}
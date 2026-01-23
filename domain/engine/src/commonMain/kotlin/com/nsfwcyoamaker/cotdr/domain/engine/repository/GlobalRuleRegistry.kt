package com.nsfwcyoamaker.cotdr.domain.engine.repository

import com.nsfwcyoamaker.cotdr.domain.engine.rules.GlobalScoreRule

interface GlobalRuleRegistry {
    fun getRules(): List<GlobalScoreRule>
}
package com.nsfwcyoamaker.cotdr.domain.engine.repository

import com.nsfwcyoamaker.cotdr.domain.engine.rules.GlobalScoreRule

interface GlobalScoreRuleRegistry {
    fun getScoreRules(): List<GlobalScoreRule>
}
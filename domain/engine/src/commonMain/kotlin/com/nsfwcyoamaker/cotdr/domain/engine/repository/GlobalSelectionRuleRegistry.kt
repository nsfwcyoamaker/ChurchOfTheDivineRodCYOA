package com.nsfwcyoamaker.cotdr.domain.engine.repository

import com.nsfwcyoamaker.cotdr.domain.engine.rules.GlobalSelectionRule

interface GlobalSelectionRuleRegistry {
    fun getRules(): List<GlobalSelectionRule>
}
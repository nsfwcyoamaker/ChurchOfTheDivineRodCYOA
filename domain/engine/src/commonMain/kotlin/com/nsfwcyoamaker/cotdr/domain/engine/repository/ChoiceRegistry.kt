package com.nsfwcyoamaker.cotdr.domain.engine.repository

import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice

interface ChoiceRegistry {
    fun getAllChoices(): List<Choice>
}
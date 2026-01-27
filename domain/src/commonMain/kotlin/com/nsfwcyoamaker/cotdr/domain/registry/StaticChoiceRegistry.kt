package com.nsfwcyoamaker.cotdr.domain.registry

import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.repository.ChoiceRegistry
import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification
import com.nsfwcyoamaker.cotdr.domain.model.Covenant
import com.nsfwcyoamaker.cotdr.domain.model.Priestess

object StaticChoiceRegistry : ChoiceRegistry {
    private val allChoices: List<Choice> = listOf(
        Priestess.entries,
        BodilyModification.all,
        Covenant.entries,
    ).flatten()

    override fun getAllChoices(): List<Choice> = allChoices
}
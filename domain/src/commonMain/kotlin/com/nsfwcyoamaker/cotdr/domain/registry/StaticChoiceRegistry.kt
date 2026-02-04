package com.nsfwcyoamaker.cotdr.domain.registry

import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.repository.ChoiceRegistry
import com.nsfwcyoamaker.cotdr.domain.model.*

object StaticChoiceRegistry: ChoiceRegistry {
    private val allChoices: List<Choice> = listOf(
        Priestess.entries,
        BodilyModification.all,
        Covenant.entries,
        Brand.all,
        ExperimentalBrand.entries,
        Contract.entries,
        ContractConduct.all,
        FollowersRuling.entries,
        ChurchRuling.entries,
        BelieversRuling.entries,
        DevoteesRuling.entries,
    ).flatten()

    override fun getAllChoices(): List<Choice> = allChoices
}
package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.AlternativeChoice
import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.model.CotdrCurrency.Fervor

interface Ruling: AlternativeChoice {
    interface RulingOption: AlternativeChoice.Alternative

    data class Relaxed(
        override val choice: Ruling,
    ): RulingOption {
        override val cost: Resources
            get() = Resources(Fervor, -1)
    }

    data class Neutral(
        override val choice: Ruling,
    ): RulingOption {
        override val cost: Resources
            get() = Resources(Fervor, 0)
    }

    data class Devoted(
        override val choice: Ruling,
    ): RulingOption {
        override val cost: Resources
            get() = Resources(Fervor, +1)
    }

    val relaxed: Relaxed
    val neutral: Neutral
    val devoted: Devoted

    override val alternatives: List<RulingOption>
        get() = listOf(relaxed, neutral, devoted)
}
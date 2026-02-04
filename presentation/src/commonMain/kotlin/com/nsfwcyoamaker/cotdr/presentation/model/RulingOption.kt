package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.Ruling
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.rulings_devoted_cost
import com.nsfwcyoamaker.cotdr.resources.rulings_neutral_cost
import com.nsfwcyoamaker.cotdr.resources.rulings_relaxed_cost
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

interface RulingOption: UiOption {
    override val choice: Ruling

    val title: StringResource
    val description: StringResource
    val relaxed: Relaxed
    val neutral: Neutral
    val devoted: Devoted

    val alternatives
        get() = listOf(relaxed, neutral, devoted)

    interface Option {
        val rulingOption: RulingOption
        val originalRulingOption: Ruling.RulingOption
        val title: StringResource
        val description: StringResource
        val image: DrawableResource
        val cost: StringResource
    }

    data class Relaxed(
        override val rulingOption: RulingOption,
        override val title: StringResource,
        override val description: StringResource,
        override val image: DrawableResource,
    ): Option {
        override val originalRulingOption: Ruling.Relaxed
            get() = rulingOption.choice.relaxed

        override val cost: StringResource = Res.string.rulings_relaxed_cost
    }

    data class Neutral(
        override val rulingOption: RulingOption,
        override val title: StringResource,
        override val description: StringResource,
        override val image: DrawableResource,
    ): Option {
        override val originalRulingOption: Ruling.Neutral
            get() = rulingOption.choice.neutral

        override val cost: StringResource = Res.string.rulings_neutral_cost
    }

    data class Devoted(
        override val rulingOption: RulingOption,
        override val title: StringResource,
        override val description: StringResource,
        override val image: DrawableResource,
    ): Option {
        override val originalRulingOption: Ruling.Devoted
            get() = rulingOption.choice.devoted

        override val cost: StringResource = Res.string.rulings_devoted_cost
    }
}
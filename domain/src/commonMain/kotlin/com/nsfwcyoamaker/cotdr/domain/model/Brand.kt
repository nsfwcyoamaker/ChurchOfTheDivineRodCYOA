package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.MandatoryChoice
import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.engine.model.SimpleChoice
import com.nsfwcyoamaker.cotdr.domain.model.CotdrCurrency.Fervor

sealed interface Brand: SimpleChoice {
    abstract class Simple: Brand, SimpleChoice {
        override val cost: Resources get() = Resources(Fervor, 0)
    }
    abstract class Mandatory: Simple(), MandatoryChoice

    data object Womb: Mandatory()
    data object Stomach: Simple()
    data object Back: Simple()
    data object LowerBack: Simple()
    data object Ass: Simple()
    data object Anus: Simple()
    data object Breast: Simple()
    data object Cleavage: Simple()
    data object Nipple: Simple()
    data object Chest: Simple()
    data object Arm: Simple()
    data object Hand: Simple()
    data object Neck: Simple()
    data object Face: Simple()
    data object Tongue: Simple()
    data object Garter: Simple()
    data object Underside: Simple()
    data object Sides: Simple()
    data object InnerThigh: Simple()
    data object Hip: Simple()
    data object Foot: Simple()

    companion object {
        val all: List<Brand>
            get() = listOf(
                Womb,
                Stomach,
                Back,
                LowerBack,
                Ass,
                Anus,
                Breast,
                Cleavage,
                Nipple,
                Chest,
                Arm,
                Hand,
                Neck,
                Face,
                Tongue,
                Garter,
                Underside,
                Sides,
                InnerThigh,
                Hip,
                Foot,
            )
    }
}
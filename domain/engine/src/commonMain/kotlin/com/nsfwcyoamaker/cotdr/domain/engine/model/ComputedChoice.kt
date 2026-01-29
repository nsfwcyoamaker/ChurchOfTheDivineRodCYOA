package com.nsfwcyoamaker.cotdr.domain.engine.model

sealed interface ComputedChoice {
    val choice: Choice
    val state: ChoiceState?
    val isAvailable: Boolean

    data class Simple(
        override val choice: SimpleChoice,
        override val state: ChoiceState.Selected? = null,
        override val isAvailable: Boolean = true,
    ): ComputedChoice

    data class MultiBuy(
        override val choice: MultibuyChoice,
        override val state: ChoiceState.MultiBuy? = null,
        override val isAvailable: Boolean = true,
        val quantity: Int = 0,
        val maxQuantity: Int? = null,
        val canBuyMore: Boolean = true,
    ): ComputedChoice

    data class Upgradable(
        override val choice: UpgradableChoice,
        override val state: ChoiceState.Upgradable? = null,
        override val isAvailable: Boolean = true,
        val isUpgradeAvailable: Boolean = true,
        val isUpgradeSelected: Boolean = false,
    ): ComputedChoice

    data class Alternative(
        override val choice: AlternativeChoice,
        override val state: ChoiceState.Alternative? = null,
        override val isAvailable: Boolean = true,
        val selected: AlternativeChoice.Option = choice.options.first(),
    ): ComputedChoice
}
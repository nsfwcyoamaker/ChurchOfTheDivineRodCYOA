package com.nsfwcyoamaker.cotdr.presentation.screens.rulings

import com.nsfwcyoamaker.cotdr.domain.engine.usecase.GetComputedChoicesUseCase
import com.nsfwcyoamaker.cotdr.domain.engine.usecase.ToggleChoiceAlternativeUseCase
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionDependencies
import kotlinx.coroutines.CoroutineScope

data class RulingsSelectionActionDependencies(
    override val coroutineScope: CoroutineScope,
    val getComputedChoicesUseCase: GetComputedChoicesUseCase,
    val toggleChoiceAlternativeUseCase: ToggleChoiceAlternativeUseCase,
): ActionDependencies()
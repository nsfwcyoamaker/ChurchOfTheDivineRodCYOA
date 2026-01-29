package com.nsfwcyoamaker.cotdr.presentation.screens.contracts

import com.nsfwcyoamaker.cotdr.domain.engine.usecase.GetComputedChoicesUseCase
import com.nsfwcyoamaker.cotdr.domain.engine.usecase.ToggleChoiceAlternativeUseCase
import com.nsfwcyoamaker.cotdr.domain.engine.usecase.ToggleChoiceUseCase
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionDependencies
import kotlinx.coroutines.CoroutineScope

data class ContractsSelectionActionDependencies(
    override val coroutineScope: CoroutineScope,
    val getComputedChoicesUseCase: GetComputedChoicesUseCase,
    val toggleChoiceUseCase: ToggleChoiceUseCase,
    val toggleChoiceAlternativeUseCase: ToggleChoiceAlternativeUseCase,
): ActionDependencies()
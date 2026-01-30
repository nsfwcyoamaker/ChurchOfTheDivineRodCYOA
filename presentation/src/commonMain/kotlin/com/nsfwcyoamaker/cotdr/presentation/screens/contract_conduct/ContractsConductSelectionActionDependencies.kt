package com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct

import com.nsfwcyoamaker.cotdr.domain.engine.usecase.GetComputedChoicesUseCase
import com.nsfwcyoamaker.cotdr.domain.engine.usecase.ToggleChoiceAlternativeUseCase
import com.nsfwcyoamaker.cotdr.domain.engine.usecase.ToggleChoiceUseCase
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionDependencies
import kotlinx.coroutines.CoroutineScope

data class ContractsConductSelectionActionDependencies(
    override val coroutineScope: CoroutineScope,
    val getComputedChoicesUseCase: GetComputedChoicesUseCase,
    val toggleChoiceUseCase: ToggleChoiceUseCase,
    val toggleChoiceAlternativeUseCase: ToggleChoiceAlternativeUseCase,
): ActionDependencies()
package com.nsfwcyoamaker.cotdr.presentation.screens.consorts

import com.nsfwcyoamaker.cotdr.domain.engine.usecase.ToggleChoiceUseCase
import com.nsfwcyoamaker.cotdr.domain.usecase.GetCurrentConsortsFlowUseCase
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionDependencies
import kotlinx.coroutines.CoroutineScope

data class ConsortsSelectionActionDependencies(
    override val coroutineScope: CoroutineScope,
    val getCurrentConsortsFlowUseCase: GetCurrentConsortsFlowUseCase,
    val toggleChoiceUseCase: ToggleChoiceUseCase,
): ActionDependencies()

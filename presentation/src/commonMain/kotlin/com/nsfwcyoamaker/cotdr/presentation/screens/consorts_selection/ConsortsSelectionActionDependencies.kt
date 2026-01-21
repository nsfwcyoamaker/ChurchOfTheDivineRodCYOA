package com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection

import com.nsfwcyoamaker.cotdr.domain.usecase.GetCurrentConsortsFlowUseCase
import com.nsfwcyoamaker.cotdr.domain.usecase.ToggleConsortUseCase
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionDependencies
import kotlinx.coroutines.CoroutineScope

data class ConsortsSelectionActionDependencies(
    override val coroutineScope: CoroutineScope,
    val getCurrentConsortsFlowUseCase: GetCurrentConsortsFlowUseCase,
    val toggleConsortUseCase: ToggleConsortUseCase,
): ActionDependencies()

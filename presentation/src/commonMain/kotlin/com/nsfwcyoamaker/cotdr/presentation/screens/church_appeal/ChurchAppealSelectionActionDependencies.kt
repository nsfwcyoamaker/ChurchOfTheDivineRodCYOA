package com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal

import com.nsfwcyoamaker.cotdr.domain.engine.usecase.GetComputedChoicesUseCase
import com.nsfwcyoamaker.cotdr.domain.engine.usecase.ToggleChoiceUseCase
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionDependencies
import kotlinx.coroutines.CoroutineScope

data class ChurchAppealSelectionActionDependencies(
    override val coroutineScope: CoroutineScope,
    val getComputedChoicesUseCase: GetComputedChoicesUseCase,
    val toggleChoiceUseCase: ToggleChoiceUseCase,
): ActionDependencies()
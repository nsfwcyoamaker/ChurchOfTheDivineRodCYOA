package com.nsfwcyoamaker.cotdr.presentation.screens

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.nsfwcyoamaker.cotdr.domain.usecase.GetTotalFervorFlowUseCase
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionViewModel
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class MainScreenModel: ScreenModel, KoinComponent {
    private val getTotalFervorFlowUseCase by inject<GetTotalFervorFlowUseCase>()
    val totalFervorFlow: Flow<Int> = getTotalFervorFlowUseCase()

    val consortsSelectionViewModel by getKoin().inject<ConsortsSelectionViewModel> { parametersOf(screenModelScope) }
    val consortsState = consortsSelectionViewModel.state
    fun runConsortsAction(action: ConsortsSelectionAction) = consortsSelectionViewModel.runAction(action)
}
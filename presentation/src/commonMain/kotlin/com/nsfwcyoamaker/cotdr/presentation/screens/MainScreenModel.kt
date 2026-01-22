package com.nsfwcyoamaker.cotdr.presentation.screens

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.nsfwcyoamaker.cotdr.domain.usecase.GetTotalFervorFlowUseCase
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class MainScreenModel: ScreenModel, KoinComponent {
    private val getTotalFervorFlowUseCase by inject<GetTotalFervorFlowUseCase>()
    val totalFervorFlow: StateFlow<Int> = getTotalFervorFlowUseCase().stateIn(screenModelScope, SharingStarted.Eagerly, 0)

    private val consortsSelectionViewModel by inject<ConsortsSelectionViewModel> { parametersOf(screenModelScope) }
    val consortsState = consortsSelectionViewModel.state
    fun runConsortsAction(action: ConsortsSelectionAction) = consortsSelectionViewModel.runAction(action)

    private val bodilyModificationsViewModel by inject<BodilyModificationsSelectionViewModel> { parametersOf(screenModelScope) }
    val bodilyModificationsState = bodilyModificationsViewModel.state
    fun runBodilyModificationsAction(action: BodilyModificationsSelectionAction) = bodilyModificationsViewModel.runAction(action)
}
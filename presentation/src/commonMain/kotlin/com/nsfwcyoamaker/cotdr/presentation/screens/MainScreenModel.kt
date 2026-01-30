package com.nsfwcyoamaker.cotdr.presentation.screens

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.nsfwcyoamaker.cotdr.domain.engine.usecase.CalculateTotalScoreUseCase
import com.nsfwcyoamaker.cotdr.domain.model.CotdrCurrency
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts.ConsortsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.ContractConductsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.ExperimentalBrandsSelectionViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class MainScreenModel: ScreenModel, KoinComponent {
    private val calculateTotalScoreUseCase by inject<CalculateTotalScoreUseCase>()
    val totalFervorFlow: StateFlow<Int> = calculateTotalScoreUseCase()
        .map { resources -> resources[CotdrCurrency.Fervor] }
        .stateIn(screenModelScope, SharingStarted.Eagerly, 0)

    val consortsSelectionViewModel by inject<ConsortsSelectionViewModel> { parametersOf(screenModelScope) }
    val bodilyModificationsViewModel by inject<BodilyModificationsSelectionViewModel> { parametersOf(screenModelScope) }
    val covenantsSelectionViewModel by inject<CovenantsSelectionViewModel> { parametersOf(screenModelScope) }
    val brandsSelectionViewModel by inject<BrandsSelectionViewModel> { parametersOf(screenModelScope) }
    val experimentalBrandsSelectionViewModel by inject<ExperimentalBrandsSelectionViewModel> { parametersOf(screenModelScope) }
    val contractsSelectionViewModel by inject<ContractsSelectionViewModel> { parametersOf(screenModelScope) }
    val contractConductsSelectionViewModel by inject<ContractConductsSelectionViewModel> { parametersOf(screenModelScope) }
}
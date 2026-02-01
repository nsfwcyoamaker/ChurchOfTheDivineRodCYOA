package com.nsfwcyoamaker.cotdr.presentation.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import com.nsfwcyoamaker.cotdr.presentation.components.CyoaBottomBar
import com.nsfwcyoamaker.cotdr.presentation.components.pages.*
import com.nsfwcyoamaker.cotdr.presentation.model.*
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

object MainScreen: Screen {
    @Composable
    override fun Content() {
        val screenModel = koinScreenModel<MainScreenModel>()

        val consortsProvider = remember(screenModel) {
            @Composable { option: PriestessIntroductionOption ->
                val state by screenModel.consortsSelectionViewModel.state.mapAsState(option) { consortsState ->
                    consortsState.items[option]
                }
                state ?: PriestessIntroductionState(option)
            }
        }

        val bodilyModProvider = remember(screenModel) {
            @Composable { option: BodilyModificationOption ->
                val state by screenModel.bodilyModificationsViewModel.state.mapAsState(option) { bodilyModificationsState ->
                    bodilyModificationsState.items[option]
                }
                state ?: BodilyModificationState(option)
            }
        }

        val covenantProvider = remember(screenModel) {
            @Composable { option: CovenantOption ->
                val state by screenModel.covenantsSelectionViewModel.state.mapAsState(option) { covenantsState ->
                    covenantsState.items[option]
                }
                state ?: CovenantState(option)
            }
        }

        val brandProvider = remember(screenModel) {
            @Composable { option: BrandOption ->
                val state by screenModel.brandsSelectionViewModel.state.mapAsState(option) { brandsState ->
                    brandsState.items[option]
                }
                state ?: BrandState(option)
            }
        }

        val experimentalBrandProvider = remember(screenModel) {
            @Composable { option: ExperimentalBrandOption ->
                val state by screenModel.experimentalBrandsSelectionViewModel.state.mapAsState(option) { brandsState ->
                    brandsState.items[option]
                }
                state ?: ExperimentalBrandState(option)
            }
        }

        val contractProvider = remember(screenModel) {
            @Composable { option: ContractOption ->
                val state by screenModel.contractsSelectionViewModel.state.mapAsState(option) { contractState ->
                    contractState.items[option]
                }
                state ?: ContractState(option)
            }
        }

        val contractConductsColumnsAmount = remember { 2 }
        val contractConductsRowsAmount by screenModel.contractConductsSelectionViewModel.state.mapAsState(contractConductsColumnsAmount) {
            (it.items.size + contractConductsColumnsAmount - 1) / contractConductsColumnsAmount
        }

        val contractConductProvider = remember(screenModel) {
            @Composable { index: Int ->
                val state by screenModel.contractConductsSelectionViewModel.state.mapAsState(index) { contractState ->
                    contractState.items.getOrNull(index)
                }
                state
            }
        }

        val churchAppealProvider = remember(screenModel) {
            @Composable { option: ChurchAppealOption ->
                val state by screenModel.churchAppealSelectionViewModel.state.mapAsState(option) { churchAppealState ->
                    churchAppealState.items[option]
                }
                state ?: ChurchAppealState(option)
            }
        }

        Scaffold(
            containerColor = Color.Transparent,
            bottomBar = {
                val fervor by screenModel.totalFervorFlow.collectAsState()
                CyoaBottomBar(currentFervor = fervor)
            }
        ) {
            MainScreenList {
                MainPage1(
                    onConsortsAction = screenModel.consortsSelectionViewModel::runAction,
                    itemStateProvider = consortsProvider,
                )

                item { Spacer(modifier = Modifier.height(60.dp)) }

                MainPage2(
                    onBodilyModificationAction = screenModel.bodilyModificationsViewModel::runAction,
                    itemStateProvider = bodilyModProvider
                )

                item { Spacer(modifier = Modifier.height(60.dp)) }

                MainPage3(
                    onCovenantAction = screenModel.covenantsSelectionViewModel::runAction,
                    itemStateProvider = covenantProvider
                )

                item { Spacer(modifier = Modifier.height(60.dp)) }

                MainPage4(
                    brandStateProvider = brandProvider,
                    onBrandAction = screenModel.brandsSelectionViewModel::runAction,
                    experimentalBrandStateProvider = experimentalBrandProvider,
                    onExperimentalBrandAction = screenModel.experimentalBrandsSelectionViewModel::runAction,
                )

                item { Spacer(modifier = Modifier.height(60.dp)) }

                MainPage5(
                    contractStateProvider = contractProvider,
                    onContractAction = screenModel.contractsSelectionViewModel::runAction,
                    contractConductsRowsAmount = contractConductsRowsAmount,
                    contractConductsColumnsAmount = contractConductsColumnsAmount,
                    contractConductStateProvider = contractConductProvider,
                    onContractConductAction = screenModel.contractConductsSelectionViewModel::runAction,
                )

                item { Spacer(modifier = Modifier.height(60.dp)) }

                MainPage6(
                    churchAppealProvider = churchAppealProvider,
                    onChurchAppealAction = screenModel.churchAppealSelectionViewModel::runAction,

                )
            }
        }
    }
}

@Composable
private fun <T, R> StateFlow<T>.mapAsState(key: Any = Unit, transform: (T) -> R): State<R> {
    val stateFlow = this

    val initialValue = remember(key) { transform(stateFlow.value) }
    val itemFlow = remember(key) {
        stateFlow
            .map { state -> transform(state) }
            .distinctUntilChanged()
    }

    return itemFlow.collectAsState(initial = initialValue)
}
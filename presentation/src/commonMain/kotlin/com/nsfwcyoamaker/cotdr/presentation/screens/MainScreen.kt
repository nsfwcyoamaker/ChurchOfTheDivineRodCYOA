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
                    itemStateProvider = { option ->
                        val state by screenModel.consortsSelectionViewModel.state.mapAsState(option) { consortsState ->
                            consortsState.items[option]
                        }
                        state ?: PriestessIntroductionState(option)
                    },
                )
                item { Spacer(modifier = Modifier.height(60.dp)) }
                MainPage2(
                    onBodilyModificationAction = screenModel.bodilyModificationsViewModel::runAction,
                    itemStateProvider = { option ->
                        val state by screenModel.bodilyModificationsViewModel.state.mapAsState(option) { bodilyModificationsState ->
                            bodilyModificationsState.items[option]
                        }
                        state ?: BodilyModificationState(option)
                    }
                )
                item { Spacer(modifier = Modifier.height(60.dp)) }
                MainPage3(
                    onCovenantAction = screenModel.covenantsSelectionViewModel::runAction,
                    itemStateProvider = { option ->
                        val state by screenModel.covenantsSelectionViewModel.state.mapAsState(option) { covenantsState ->
                            covenantsState.items[option]
                        }
                        state ?: CovenantState(option)
                    }
                )
                item { Spacer(modifier = Modifier.height(60.dp)) }
                MainPage4(
                    brandStateProvider = { option ->
                        val state by screenModel.brandsSelectionViewModel.state.mapAsState(option) { brandsState ->
                            brandsState.items[option]
                        }
                        state ?: BrandState(option)
                    },
                    onBrandAction = screenModel.brandsSelectionViewModel::runAction,
                    experimentalBrandStateProvider = { option ->
                        val state by screenModel.experimentalBrandsSelectionViewModel.state.mapAsState(option) { brandsState ->
                            brandsState.items[option]
                        }
                        state ?: ExperimentalBrandState(option)
                    },
                    onExperimentalBrandAction = screenModel.experimentalBrandsSelectionViewModel::runAction,
                )
                item { Spacer(modifier = Modifier.height(60.dp)) }
                MainPage5(
                    contractStateProvider = { option ->
                        val state by screenModel.contractsSelectionViewModel.state.mapAsState(option) { contractState ->
                            contractState.items[option]
                        }
                        state ?: ContractState(option)
                    },
                    onContractAction = screenModel.contractsSelectionViewModel::runAction,
                )
            }
        }
    }
}

@Composable
private fun <T, R> StateFlow<T>.mapAsState(key: Any, transform: (T) -> R): State<R> {
    val stateFlow = this

    val initialValue = remember(key) { transform(stateFlow.value) }
    val itemFlow = remember(key) {
        stateFlow
            .map { state -> transform(state) }
            .distinctUntilChanged()
    }

    return itemFlow.collectAsState(initial = initialValue)
}
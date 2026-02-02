package com.nsfwcyoamaker.cotdr.presentation.components.sections.servant_conduct

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.domain.model.Contract
import com.nsfwcyoamaker.cotdr.domain.model.ContractConduct
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.model.ContractConductOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractConductState
import com.nsfwcyoamaker.cotdr.presentation.model.ContractOption
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.ContractConductsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.action.ToggleContractAction
import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.action.ToggleContractConductAction
import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.action.ToggleContractLevelAction
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.ServantConductGridItem(
    contractConductsRowsAmount: Int,
    contractConductsColumnsAmount: Int,
    contractConductStateProvider: @Composable (Int) -> ContractConductState?,
    onContractConductAction: (ContractConductsSelectionAction) -> Unit
) {
    repeat(contractConductsRowsAmount) { rowIndex ->
        item(
            key = "servant_conduct_selection_row_$rowIndex",
            contentType = "servant_conduct_selection_row"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)
            ) {
                repeat(contractConductsColumnsAmount) { columnIndex ->
                    val itemIndex = rowIndex * contractConductsColumnsAmount + columnIndex
                    val state = contractConductStateProvider(itemIndex)
                    Box(Modifier.weight(1f).fillMaxHeight()) {
                        state?.let { contractConductState ->
                            ConductCard(
                                state = contractConductState,
                                onSelected = { onContractConductAction(ToggleContractAction(contractConductState.option.parentContractOption.choice)) },
                                onContractLevelSelected = { onContractConductAction(ToggleContractLevelAction(it)) },
                                onContractConductSelected = { onContractConductAction(ToggleContractConductAction(it)) },
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }

        if (rowIndex < contractConductsRowsAmount - 1) {
            item { Spacer(Modifier.height(24.dp)) }
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun ServantConductGridItemPreview() {
    AppScope {
        MainScreenList {
            ServantConductGridItem(
                contractConductsRowsAmount = 1,
                contractConductsColumnsAmount = 2,
                contractConductStateProvider = {
                    ContractConductState(
                        ContractConductOption(ContractConduct(Contract.Virgo), ContractOption.Virgo)
                    )
                },
                onContractConductAction = {},
            )
        }
    }
}
package com.nsfwcyoamaker.cotdr.presentation.components.sections.contracts

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.ChoicesGrid
import com.nsfwcyoamaker.cotdr.presentation.model.ContractOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractState
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.action.ToggleContractAction
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.action.ToggleContractAlternativeAction
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.ContractsGridItem(
    itemStateProvider: @Composable (ContractOption) -> ContractState,
    onContractAction: (ContractsSelectionAction) -> Unit
) {
    ChoicesGrid(
        items = ContractOption.entries,
        columns = 2,
        key = "contracts_row",
        contentType = "contracts_row",
        itemContent = { option ->
            val state = itemStateProvider(option)
            ContractCard(
                state = state,
                onSelected = {
                    onContractAction(ToggleContractAction(state.option.choice))
                },
            )
        },
        extraContent = { option ->
            val state = itemStateProvider(option)

            ContractAlternativeRow(
                alternativeStates = state.alternatives,
                onSelected = { alternative ->
                    onContractAction(ToggleContractAlternativeAction(alternative.contractAlternative))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
        }
    )
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun ContractsGridItemPreview() {
    AppScope {
        MainScreenList {
            ContractsGridItem(
                { option -> ContractState(option) },
                {},
            )
        }
    }
}
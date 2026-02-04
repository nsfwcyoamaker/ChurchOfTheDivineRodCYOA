package com.nsfwcyoamaker.cotdr.presentation.components.sections.contracts

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.SelectableCard
import com.nsfwcyoamaker.cotdr.presentation.model.ContractOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractState
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ContractCard(
    state: ContractState,
    onSelected: () -> Unit,
    onContractLevelSelected: (ContractOption.ContractLevel) -> Unit,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = state.isSelected,
        isClickable = state.isEnabled,
        onSelected = onSelected,
        modifier = modifier,
    ) {
        ContractCardContent(
            state = state,
            onContractLevelSelected = onContractLevelSelected,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        )
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun ContractCardPreview() {
    AppScope {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            ContractCard(
                state = ContractState(ContractOption.FelicLusch),
                onSelected = {},
                onContractLevelSelected = {},
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .wrapContentHeight(),
            )
        }
    }
}
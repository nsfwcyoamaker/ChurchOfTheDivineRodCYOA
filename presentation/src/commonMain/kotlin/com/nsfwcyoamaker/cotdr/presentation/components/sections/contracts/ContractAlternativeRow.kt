package com.nsfwcyoamaker.cotdr.presentation.components.sections.contracts

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.model.ContractOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractState
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ContractAlternativeRow(
    alternativeStates: List<ContractState.AlternativeState>,
    onSelected: (ContractState.AlternativeState) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = modifier,
    ) {
        alternativeStates.forEach { alternativeState ->
            ContractAlternativeCard(
                alternativeState = alternativeState,
                onSelected = { onSelected(alternativeState) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun ContractAlternativeRowPreview() {
    AppScope {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            ContractAlternativeRow(
                alternativeStates = ContractOption.FelicLusch.alternatives.map(ContractState::AlternativeState),
                {},
                modifier = Modifier
                    .fillMaxWidth(0.45f)
                    .wrapContentHeight(),
            )
        }
    }
}
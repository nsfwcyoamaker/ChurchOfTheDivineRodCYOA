package com.nsfwcyoamaker.cotdr.presentation.components.sections.servant_conduct

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.domain.model.Contract
import com.nsfwcyoamaker.cotdr.domain.model.ContractConduct
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.SelectableCard
import com.nsfwcyoamaker.cotdr.presentation.components.sections.contracts.ContractCardContent
import com.nsfwcyoamaker.cotdr.presentation.model.ContractConductOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractConductState
import com.nsfwcyoamaker.cotdr.presentation.model.ContractOption
import com.nsfwcyoamaker.cotdr.presentation.theme.smallerTextStyle
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ContractCardExtended(
    state: ContractConductState,
    onSelected: () -> Unit,
    onContractLevelSelected: (ContractOption.ContractLevel) -> Unit,
    onContractConductSelected: (ContractConductOption.Conduct) -> Unit,
    modifier: Modifier = Modifier
) {
    SelectableCard(
        isSelected = state.isSelected,
        isClickable = state.isEnabled,
        onSelected = onSelected,
        modifier = modifier,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        ) {
            ContractCardContent(
                state = state.contractState,
                onContractLevelSelected = onContractLevelSelected,
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                state.conducts.forEach { conductState ->
                    ContractConductCard(
                        conductState = conductState,
                        onClick = { onContractConductSelected(conductState.conductOption) },
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentHeight()
                    )
                }
            }
        }
    }
}

@Composable
private fun ContractConductCard(
    conductState: ContractConductState.ConductState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = conductState.isSelected,
        isClickable = true,
        onSelected = onClick,
        cornerBracketsVisible = false,
        modifier = modifier,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = rememberRichTextResource(conductState.conductOption.ui.title).text,
                style = smallerTextStyle.copy(
                    fontWeight = FontWeight.Bold,
                ),
            )

            Text(
                text = rememberRichTextResource(conductState.conductOption.ui.description),
                style = smallerTextStyle,
            )

            Box(modifier = Modifier.weight(1f))

            Text(
                text = rememberRichTextResource(conductState.conductOption.ui.cost),
            )
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
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            ContractCardExtended(
                state = ContractConductState(ContractConductOption(ContractConduct(Contract.Virgo), ContractOption.Virgo)),
                onSelected = {},
                onContractLevelSelected = {},
                onContractConductSelected = {},
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .wrapContentHeight(),
            )
        }
    }
}
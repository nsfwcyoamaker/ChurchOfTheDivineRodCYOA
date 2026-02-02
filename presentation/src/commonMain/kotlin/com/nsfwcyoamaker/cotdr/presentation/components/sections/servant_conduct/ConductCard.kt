package com.nsfwcyoamaker.cotdr.presentation.components.sections.servant_conduct

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.domain.model.Contract
import com.nsfwcyoamaker.cotdr.domain.model.ContractConduct
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.HighlightCenter
import com.nsfwcyoamaker.cotdr.presentation.components.SelectableCard
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.presentation.model.ContractConductOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractConductState
import com.nsfwcyoamaker.cotdr.presentation.model.ContractOption
import com.nsfwcyoamaker.cotdr.presentation.theme.smallTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.smallerTitleTextStyle
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun ConductCard(
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .fillMaxSize(),
        ) {
            HighlightCenter(
                inverted = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = rememberRichTextResource(state.contractState.option.title),
                    style = smallTitleTextStyle,
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.Top,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp, alignment = Alignment.Top),
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(state.contractState.option.demonImage),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .wrapContentHeight()
                            .shadowBorder()
                    )
                }

                Column(
                    modifier = Modifier.weight(3f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp, alignment = Alignment.Top)
                ) {
                    state.conducts.forEach { conductState ->
                        ContractConductSummaryRow(
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
}

@Composable
private fun ContractConductSummaryRow(
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
        ) {
            Text(
                text = rememberRichTextResource(conductState.conductOption.ui.title),
                style = smallerTitleTextStyle,
            )

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
private fun ConductCardPreview() {
    AppScope {
        Box(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center,
        ) {
            ConductCard(
                state = ContractConductState(ContractConductOption(ContractConduct(Contract.Virgo), ContractOption.Virgo)),
                onSelected = {},
                onContractLevelSelected = {},
                onContractConductSelected = {},
                modifier = Modifier.fillMaxWidth(0.4f),
            )
        }
    }
}
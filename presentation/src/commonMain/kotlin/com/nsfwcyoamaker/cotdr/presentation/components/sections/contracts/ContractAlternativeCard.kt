package com.nsfwcyoamaker.cotdr.presentation.components.sections.contracts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.SelectableCard
import com.nsfwcyoamaker.cotdr.presentation.model.ContractOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractState
import com.nsfwcyoamaker.cotdr.presentation.theme.headerTextStyle
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ContractAlternativeCard(
    alternativeState: ContractState.AlternativeState,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = alternativeState.isSelected,
        isClickable = true,
        onSelected = onSelected,
        cornerBracketsVisible = false,
        modifier = modifier,
    ) {
        Text(
            text = rememberRichTextResource(alternativeState.contractAlternative.text),
            style = headerTextStyle,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun ContractAlternativeCardPreview() {
    AppScope {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            ContractAlternativeCard(
                alternativeState = ContractState.AlternativeState(
                    contractAlternative = ContractOption.Servant(ContractOption.FelicLusch),
                    isSelected = false,
                ),
                {},
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .wrapContentHeight(),
            )
        }
    }
}
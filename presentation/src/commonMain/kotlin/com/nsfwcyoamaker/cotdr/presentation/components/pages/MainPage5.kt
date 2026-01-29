package com.nsfwcyoamaker.cotdr.presentation.components.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.WIPItem
import com.nsfwcyoamaker.cotdr.presentation.components.sections.contracts.ContractsDescription
import com.nsfwcyoamaker.cotdr.presentation.components.sections.contracts.ContractsGridItem
import com.nsfwcyoamaker.cotdr.presentation.components.sections.contracts.ContractsTitle
import com.nsfwcyoamaker.cotdr.presentation.components.sections.demons.DemonsDescription
import com.nsfwcyoamaker.cotdr.presentation.components.sections.demons.DemonsTitle
import com.nsfwcyoamaker.cotdr.presentation.components.sections.servant_conduct.ServantConductDescription
import com.nsfwcyoamaker.cotdr.presentation.components.sections.servant_conduct.ServantConductExtra
import com.nsfwcyoamaker.cotdr.presentation.components.sections.servant_conduct.ServantConductItemsRow
import com.nsfwcyoamaker.cotdr.presentation.components.sections.servant_conduct.ServantConductTitle
import com.nsfwcyoamaker.cotdr.presentation.model.ContractOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractState
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionAction
import org.jetbrains.compose.ui.tooling.preview.Preview

fun LazyListScope.MainPage5(
    contractStateProvider: @Composable (ContractOption) -> ContractState,
    onContractAction: (ContractsSelectionAction) -> Unit,
) {
    item(
        key = "DemonsTitle",
        contentType = "DemonsTitle"
    ) { DemonsTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "DemonsDescription",
        contentType = "DemonsDescription"
    ) { DemonsDescription() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "ContractsTitle",
        contentType = "ContractsTitle"
    ) { ContractsTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "ContractsDescription",
        contentType = "ContractsDescription"
    ) { ContractsDescription() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    ContractsGridItem(
        itemStateProvider = contractStateProvider,
        onContractAction = onContractAction,
    )

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "ServantConductTitle",
        contentType = "ServantConductTitle",
    ) { ServantConductTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "ServantConductDescription",
        contentType = "ServantConductDescription",
    ) { ServantConductDescription() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "ServantConductWIP",
        contentType = "ServantConductWIP",
    ) { WIPItem() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "ServantConductItemsRow",
        contentType = "ServantConductItemsRow",
    ) { ServantConductItemsRow() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "ServantConductExtra",
        contentType = "ServantConductExtra",
    ) { ServantConductExtra() }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun MainPage4Preview() {
    AppScope {
        MainScreenList {
            MainPage5(
                { option -> ContractState(option) },
                {},
            )
        }
    }
}
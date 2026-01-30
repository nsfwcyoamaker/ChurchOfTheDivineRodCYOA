package com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct

import com.nsfwcyoamaker.cotdr.presentation.model.ContractConductOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractConductState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ViewState

data class ContractConductsSelectionState(
    val items: Map<ContractConductOption, ContractConductState> = defaultState(),
): ViewState {
    companion object {
        fun defaultState() = ContractConductOption.all.associateWith(::ContractConductState)
    }
}
package com.nsfwcyoamaker.cotdr.presentation.screens.contracts

import com.nsfwcyoamaker.cotdr.presentation.model.ContractOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ViewState

data class ContractsSelectionState(
    val items: Map<ContractOption, ContractState> = defaultState(),
): ViewState {
    companion object {
        fun defaultState() = ContractOption.entries.associateWith(::ContractState)
    }
}
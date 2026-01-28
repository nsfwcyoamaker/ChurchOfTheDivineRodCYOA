package com.nsfwcyoamaker.cotdr.presentation.screens.covenants

import com.nsfwcyoamaker.cotdr.presentation.model.CovenantOption
import com.nsfwcyoamaker.cotdr.presentation.model.CovenantState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ViewState

data class CovenantsSelectionState(
    val items: Map<CovenantOption, CovenantState> = defaultState(),
): ViewState {
    companion object {
        fun defaultState() = CovenantOption.entries.associateWith(::CovenantState)
    }
}
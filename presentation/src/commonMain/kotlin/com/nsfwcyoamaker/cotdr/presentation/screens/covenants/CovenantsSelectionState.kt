package com.nsfwcyoamaker.cotdr.presentation.screens.covenants

import com.nsfwcyoamaker.cotdr.presentation.model.CovenantOption
import com.nsfwcyoamaker.cotdr.presentation.model.CovenantState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ViewState

data class CovenantsSelectionState(
    val items: List<CovenantState> = defaultState(),
): ViewState {
    companion object {
        fun defaultState() = CovenantOption.entries.map(::CovenantState)
    }
}
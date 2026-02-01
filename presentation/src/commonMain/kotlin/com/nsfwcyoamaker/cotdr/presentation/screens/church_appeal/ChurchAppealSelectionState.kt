package com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal

import com.nsfwcyoamaker.cotdr.presentation.model.ChurchAppealOption
import com.nsfwcyoamaker.cotdr.presentation.model.ChurchAppealState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ViewState

data class ChurchAppealSelectionState(
    val items: Map<ChurchAppealOption, ChurchAppealState> = defaultState(),
): ViewState {
    companion object {
        fun defaultState() = ChurchAppealOption.entries.associateWith(::ChurchAppealState)
    }
}
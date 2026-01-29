package com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications

import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationOption
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ViewState

data class BodilyModificationsSelectionState(
    val items: Map<BodilyModificationOption, BodilyModificationState> = defaultState(),
): ViewState {
    companion object {
        fun defaultState() = BodilyModificationOption.all.associateWith(::BodilyModificationState)
    }
}
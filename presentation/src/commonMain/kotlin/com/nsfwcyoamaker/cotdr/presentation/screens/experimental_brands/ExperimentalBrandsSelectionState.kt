package com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands

import com.nsfwcyoamaker.cotdr.presentation.model.ExperimentalBrandOption
import com.nsfwcyoamaker.cotdr.presentation.model.ExperimentalBrandState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ViewState

data class ExperimentalBrandsSelectionState(
    val items: Map<ExperimentalBrandOption, ExperimentalBrandState> = defaultState(),
): ViewState {
    companion object {
        fun defaultState() = ExperimentalBrandOption.entries.associateWith(::ExperimentalBrandState)
    }
}
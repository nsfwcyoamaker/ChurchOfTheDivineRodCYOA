package com.nsfwcyoamaker.cotdr.presentation.screens.brands

import com.nsfwcyoamaker.cotdr.presentation.model.BrandOption
import com.nsfwcyoamaker.cotdr.presentation.model.BrandState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ViewState

data class BrandsSelectionState(
    val items: List<BrandState> = defaultState(),
): ViewState {
    companion object {
        fun defaultState() = BrandOption.entries.map(::BrandState)
    }
}
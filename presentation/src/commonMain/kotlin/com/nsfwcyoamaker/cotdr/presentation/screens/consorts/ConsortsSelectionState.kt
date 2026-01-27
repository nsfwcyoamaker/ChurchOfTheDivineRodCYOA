package com.nsfwcyoamaker.cotdr.presentation.screens.consorts

import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroductionOption
import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroductionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ViewState

data class ConsortsSelectionState(
    val priestessesState: List<List<PriestessIntroductionState>> = defaultState(),
): ViewState {
    companion object {
        fun defaultState() = PriestessIntroductionOption.entries.map {
            PriestessIntroductionState(
                priestessIntroductionOption = it,
                isClickable = true,
                isSelected = false,
            )
        }.chunked(3)
    }
}
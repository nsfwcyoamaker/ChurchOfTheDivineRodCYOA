package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.action.TogglePriestessAction

data class PriestessIntroductionState(
    val priestessIntroductionOption: PriestessIntroductionOption,
    val clickAction: ConsortsSelectionAction? = priestessIntroductionOption.priestess?.let { TogglePriestessAction(it) },
    val isClickable: Boolean = true,
    val isSelected: Boolean = false,
)
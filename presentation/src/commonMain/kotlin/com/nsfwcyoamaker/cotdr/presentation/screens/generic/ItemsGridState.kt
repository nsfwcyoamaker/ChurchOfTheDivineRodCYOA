package com.nsfwcyoamaker.cotdr.presentation.screens.generic

import com.nsfwcyoamaker.cotdr.presentation.model.UiItemState
import com.nsfwcyoamaker.cotdr.presentation.model.UiOption

interface ItemsGridState<Option: UiOption, State: UiItemState> {
    val items: Map<Option, State>
}
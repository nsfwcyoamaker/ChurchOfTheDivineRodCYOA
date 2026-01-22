package com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications

import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationExtraState
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationOption
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ViewState

data class BodilyModificationsSelectionState(
    val bodilyModifications: List<Row> = defaultState(),
): ViewState {
    sealed interface Row {
        data class ChoicesRow(val choices: List<BodilyModificationState>): Row
        data class ExtrasRow(val extras: List<BodilyModificationExtraState>): Row
    }
    companion object {
        fun defaultState() = BodilyModificationOption.entries
            .map { BodilyModificationState(bodilyModificationOption = it) }
            .chunked(3)
            .map { Row.ChoicesRow(it) }
    }
}
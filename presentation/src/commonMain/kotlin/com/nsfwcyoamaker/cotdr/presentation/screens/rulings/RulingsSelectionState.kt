package com.nsfwcyoamaker.cotdr.presentation.screens.rulings

import com.nsfwcyoamaker.cotdr.presentation.model.FollowersRulingOption
import com.nsfwcyoamaker.cotdr.presentation.model.RulingOption
import com.nsfwcyoamaker.cotdr.presentation.model.RulingState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ViewState

data class RulingsSelectionState(
    val items: Map<RulingOption, Map<RulingOption.Option, RulingState.RulingOptionState>> = defaultState(),
): ViewState {
    companion object {
        fun defaultState() = buildMap<RulingOption, Map<RulingOption.Option, RulingState.RulingOptionState>> {
            listOf(
                FollowersRulingOption.entries,
                //todo others
            ).flatten().forEach { rulingOption ->
                put(
                    key = rulingOption,
                    value = RulingState(rulingOption)
                        .let { state -> state.rulingOptions.associateBy { state -> state.rulingOption } }
                )
            }
        }
    }
}
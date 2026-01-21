package com.nsfwcyoamaker.cotdr.domain.repository

import com.nsfwcyoamaker.cotdr.domain.model.Choice
import com.nsfwcyoamaker.cotdr.domain.model.ChoiceState
import kotlinx.coroutines.flow.StateFlow

interface GameStateRepository {
    val selectedChoicesStateFlow: StateFlow<Map<Choice, ChoiceState>>
    fun setChoiceState(choice: Choice, state: ChoiceState?)
}
package com.nsfwcyoamaker.cotdr.domain.engine.repository

import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import kotlinx.coroutines.flow.StateFlow

interface GameStateRepository {
    val selectedChoicesStateFlow: StateFlow<Map<Choice, ChoiceState>>
    fun setSelectedChoices(newState: Map<Choice, ChoiceState>)
}
package com.nsfwcyoamaker.cotdr.data.repository

import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GameStateRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameStateRepositoryImpl: GameStateRepository {
    private val _selectedChoicesStateFlow = MutableStateFlow<Map<Choice, ChoiceState>>(emptyMap())
    override val selectedChoicesStateFlow = _selectedChoicesStateFlow.asStateFlow()

    override fun setSelectedChoices(newState: Map<Choice, ChoiceState>) {
        _selectedChoicesStateFlow.value = newState
    }
}
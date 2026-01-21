package com.nsfwcyoamaker.cotdr.data.repository

import com.nsfwcyoamaker.cotdr.domain.model.Choice
import com.nsfwcyoamaker.cotdr.domain.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.repository.GameStateRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameStateRepositoryImpl: GameStateRepository {
    private val _selectedChoicesStateFlow = MutableStateFlow<Map<Choice, ChoiceState>>(emptyMap())
    override val selectedChoicesStateFlow = _selectedChoicesStateFlow.asStateFlow()

    override fun setChoiceState(
        choice: Choice,
        state: ChoiceState?
    ) {
        _selectedChoicesStateFlow.update { currentState ->
            if(state == null) {
                currentState - choice
            } else {
                currentState + (choice to state)
            }
        }
    }
}
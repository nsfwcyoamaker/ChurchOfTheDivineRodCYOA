package com.nsfwcyoamaker.cotdr.data.repository

import com.nsfwcyoamaker.cotdr.domain.model.Priestess
import com.nsfwcyoamaker.cotdr.domain.repository.GameStateRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameStateRepositoryImpl: GameStateRepository {
    private val _selectedConsortsFlow = MutableStateFlow(emptySet<Priestess>())
    override val selectedConsortsFlow = _selectedConsortsFlow.asStateFlow()

    override fun toggleConsort(priestess: Priestess) {
        _selectedConsortsFlow.update { current ->
            if (priestess in current) {
                current - priestess
            } else {
                current + priestess
            }
        }
    }
}
package com.nsfwcyoamaker.cotdr.domain.repository

import com.nsfwcyoamaker.cotdr.domain.model.Priestess
import kotlinx.coroutines.flow.StateFlow

interface GameStateRepository {
    val selectedConsortsFlow: StateFlow<Set<Priestess>>
    fun toggleConsort(priestess: Priestess)
}
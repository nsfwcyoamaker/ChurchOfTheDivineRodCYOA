package com.nsfwcyoamaker.cotdr.domain.usecase

import com.nsfwcyoamaker.cotdr.domain.repository.GameStateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTotalFervorFlowUseCase(
    private val repository: GameStateRepository,
) {
    operator fun invoke(): Flow<Int> {
        return repository.selectedConsortsFlow.map { consorts ->
            consorts.count().let { amount -> ((amount*(amount-1))/2) * -1 }
        }
    }
}
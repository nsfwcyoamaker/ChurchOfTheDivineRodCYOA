package com.nsfwcyoamaker.cotdr.presentation.mapper

import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ComputedChoice
import com.nsfwcyoamaker.cotdr.domain.engine.usecase.GetComputedChoicesUseCase
import com.nsfwcyoamaker.cotdr.presentation.model.UiOption
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object UiChoiceMapper {
    inline fun <C: Choice, O: UiOption, R> mapStateFor(
        items: List<C>,
        options: List<O>,
        getComputedChoicesUseCase: GetComputedChoicesUseCase,
        crossinline makeState: (ComputedChoice, O) -> R
    ): Flow<List<R>> {
        val optionMap = options.associateBy { it.choice }

        return getComputedChoicesUseCase(items).map { computedChoices ->
            computedChoices.mapNotNull { computed ->
                makeState(
                    computed,
                    optionMap[computed.choice] ?: return@mapNotNull null,
                )
            }
        }
    }
}
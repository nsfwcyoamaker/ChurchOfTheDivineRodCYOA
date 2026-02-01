package com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal.action

import com.nsfwcyoamaker.cotdr.domain.model.ChurchAppeal
import com.nsfwcyoamaker.cotdr.presentation.mapper.UiChoiceMapper
import com.nsfwcyoamaker.cotdr.presentation.model.ChurchAppealOption
import com.nsfwcyoamaker.cotdr.presentation.model.ChurchAppealState
import com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal.ChurchAppealSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal.ChurchAppealSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal.ChurchAppealSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

object ObserveChurchAppealAction: ChurchAppealSelectionAction {
    override suspend fun execute(
        dependencies: ChurchAppealSelectionActionDependencies,
        scope: ActionScope<ChurchAppealSelectionState, Nothing>
    ) {
        UiChoiceMapper.mapStateFor(
            items = ChurchAppeal.entries,
            options = ChurchAppealOption.entries,
            getComputedChoicesUseCase = dependencies.getComputedChoicesUseCase,
            makeState = { computed, option ->
                ChurchAppealState(
                    option = option,
                    isSelected = computed.state != null,
                )
            }
        ).collect { items ->
            scope.setState { ChurchAppealSelectionState(items = items.associateBy { it.option }) }
        }
    }
}
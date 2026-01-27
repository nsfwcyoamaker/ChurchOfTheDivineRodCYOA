package com.nsfwcyoamaker.cotdr.presentation.screens.covenants.action

import com.nsfwcyoamaker.cotdr.domain.model.Covenant
import com.nsfwcyoamaker.cotdr.presentation.mapper.UiChoiceMapper
import com.nsfwcyoamaker.cotdr.presentation.model.CovenantOption
import com.nsfwcyoamaker.cotdr.presentation.model.CovenantState
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

object ObserveCovenantsAction: CovenantsSelectionAction {
    override suspend fun execute(
        dependencies: CovenantsSelectionActionDependencies,
        scope: ActionScope<CovenantsSelectionState, Nothing>
    ) {
        UiChoiceMapper.mapStateFor(
            items = Covenant.entries,
            options = CovenantOption.entries,
            getComputedChoicesUseCase = dependencies.getComputedChoicesUseCase,
            makeState = { computed, option ->
                CovenantState(
                    option = option,
                    isSelected = computed.state != null,
                    isEnabled = computed.isAvailable,
                )
            }
        ).collect { items ->
            scope.setState { CovenantsSelectionState(items = items) }
        }
    }
}
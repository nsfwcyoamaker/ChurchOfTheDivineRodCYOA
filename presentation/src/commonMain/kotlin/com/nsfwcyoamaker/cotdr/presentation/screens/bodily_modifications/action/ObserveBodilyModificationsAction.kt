package com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action

import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification
import com.nsfwcyoamaker.cotdr.presentation.mapper.UiChoiceMapper
import com.nsfwcyoamaker.cotdr.presentation.mapper.UiControlMapper
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationOption
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationState
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

object ObserveBodilyModificationsAction: BodilyModificationsSelectionAction {
    override suspend fun execute(
        dependencies: BodilyModificationsSelectionActionDependencies,
        scope: ActionScope<BodilyModificationsSelectionState, Nothing>
    ) {
        UiChoiceMapper.mapStateFor(
            items = BodilyModification.all,
            options = BodilyModificationOption.entries,
            getComputedChoicesUseCase = dependencies.getComputedChoicesUseCase,
            makeState = { computed, option ->
                BodilyModificationState(
                    option = option,
                    isSelected = computed.state != null,
                    isEnabled = computed.isAvailable,
                    control = UiControlMapper.map(computed, option.upgradeText)
                )
            }
        ).collect { items ->
            scope.setState { BodilyModificationsSelectionState(items = items.associateBy { it.option }) }
        }
    }
}
package com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.action

import com.nsfwcyoamaker.cotdr.domain.model.ExperimentalBrand
import com.nsfwcyoamaker.cotdr.presentation.mapper.UiChoiceMapper
import com.nsfwcyoamaker.cotdr.presentation.model.ExperimentalBrandOption
import com.nsfwcyoamaker.cotdr.presentation.model.ExperimentalBrandState
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.ExperimentalBrandsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.ExperimentalBrandsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.ExperimentalBrandsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

object ObserveExperimentalBrandsAction: ExperimentalBrandsSelectionAction {
    override suspend fun execute(
        dependencies: ExperimentalBrandsSelectionActionDependencies,
        scope: ActionScope<ExperimentalBrandsSelectionState, Nothing>
    ) {
        UiChoiceMapper.mapStateFor(
            items = ExperimentalBrand.entries,
            options = ExperimentalBrandOption.entries,
            getComputedChoicesUseCase = dependencies.getComputedChoicesUseCase,
            makeState = { computed, option ->
                ExperimentalBrandState(
                    option = option,
                    isSelected = computed.state != null,
                    isEnabled = computed.isAvailable,
                )
            }
        ).collect { items ->
            scope.setState { ExperimentalBrandsSelectionState(items = items) }
        }
    }
}
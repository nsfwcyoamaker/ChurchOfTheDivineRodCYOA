package com.nsfwcyoamaker.cotdr.presentation.screens.brands.action

import com.nsfwcyoamaker.cotdr.domain.model.Brand
import com.nsfwcyoamaker.cotdr.presentation.mapper.UiChoiceMapper
import com.nsfwcyoamaker.cotdr.presentation.model.BrandOption
import com.nsfwcyoamaker.cotdr.presentation.model.BrandState
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

object ObserveBrandsAction: BrandsSelectionAction {
    override suspend fun execute(
        dependencies: BrandsSelectionActionDependencies,
        scope: ActionScope<BrandsSelectionState, Nothing>
    ) {
        UiChoiceMapper.mapStateFor(
            items = Brand.all,
            options = BrandOption.entries,
            getComputedChoicesUseCase = dependencies.getComputedChoicesUseCase,
            makeState = { computed, option ->
                BrandState(
                    option = option,
                    isSelected = computed.state != null,
                    isEnabled = computed.isAvailable,
                )
            }
        ).collect { items ->
            scope.setState { BrandsSelectionState(items = items.associateBy { it.option }) }
        }
    }
}
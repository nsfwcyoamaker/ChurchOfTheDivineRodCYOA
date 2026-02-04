package com.nsfwcyoamaker.cotdr.presentation.screens.rulings.action

import com.nsfwcyoamaker.cotdr.domain.engine.model.ComputedChoice
import com.nsfwcyoamaker.cotdr.domain.model.ChurchRuling
import com.nsfwcyoamaker.cotdr.domain.model.FollowersRuling
import com.nsfwcyoamaker.cotdr.presentation.mapper.UiChoiceMapper
import com.nsfwcyoamaker.cotdr.presentation.model.ChurchRulingOption
import com.nsfwcyoamaker.cotdr.presentation.model.FollowersRulingOption
import com.nsfwcyoamaker.cotdr.presentation.model.RulingState
import com.nsfwcyoamaker.cotdr.presentation.screens.rulings.RulingsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.rulings.RulingsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.rulings.RulingsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

object ObserveRulingsAction: RulingsSelectionAction {
    override suspend fun execute(
        dependencies: RulingsSelectionActionDependencies,
        scope: ActionScope<RulingsSelectionState, Nothing>
    ) {
        UiChoiceMapper.mapStateFor(
            items = listOf(
                FollowersRuling.entries,
                ChurchRuling.entries,
                //++the others?
            ).flatten(),
            options = listOf(
                FollowersRulingOption.entries,
                ChurchRulingOption.entries,
                //++the others?
            ).flatten(),
            getComputedChoicesUseCase = dependencies.getComputedChoicesUseCase,
            makeState = { computed, option ->
                val computedAlternative = computed as? ComputedChoice.Alternative

                val rulingOptions = option.alternatives.map { rulingOption ->
                    RulingState.RulingOptionState(
                        rulingOption = rulingOption,
                        isSelected = rulingOption.originalRulingOption == computedAlternative?.state?.selected
                    )
                }

                RulingState(
                    option = option,
                    rulingOptions = rulingOptions
                )
            }
        ).collect { items ->
            scope.setState { RulingsSelectionState(items = items.associateBy { it.option }.mapValues { (_, state) -> state.rulingOptions.associateBy { state -> state.rulingOption } }) }
        }
    }
}
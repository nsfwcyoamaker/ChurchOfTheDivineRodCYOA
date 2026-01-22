package com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action

import com.nsfwcyoamaker.cotdr.domain.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.rules.CostStrategy
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationExtraState
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationOption
import com.nsfwcyoamaker.cotdr.presentation.model.BodilyModificationState
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

object ObserveBodilyModificationsSelectionStateAction: BodilyModificationsSelectionAction {
    override suspend fun execute(
        dependencies: BodilyModificationsSelectionActionDependencies,
        scope: ActionScope<BodilyModificationsSelectionState, Nothing>
    ) {
        dependencies.getCurrentChoicesFlowUseCase().collect { allChoices ->
            val context = CalculationContext(allChoices)

            val options = BodilyModificationOption.entries
                .map { option ->
                    val state = allChoices[option.bodilyModification]
                        ?: return@map BodilyModificationState(option) to BodilyModificationExtraState.EmptyOption
                    val requirementsMet = option.bodilyModification.requirements(context)

                    if (!requirementsMet) {
                        return@map BodilyModificationState(
                            option,
                            isEnabled = false
                        ) to BodilyModificationExtraState.EmptyOption
                    }

                    val fervorContribution = option.bodilyModification.strategy.calculateCost(state, context)

                    val item = BodilyModificationState(
                        bodilyModificationOption = option,
                        isSelected = requirementsMet,
                        isEnabled = true,
                        fervorContribution = fervorContribution,
                    )

                    val multiBuy = option.bodilyModification.strategy as? CostStrategy.MultiBuy
                    if (multiBuy != null) {
                        if(state.quantity < 1) return@map BodilyModificationState(option) to BodilyModificationExtraState.EmptyOption
                    }

                    val upgrade = option.bodilyModification.strategy as? CostStrategy.Upgradable

                    val extra = when {
                        multiBuy != null -> {
                            BodilyModificationExtraState.MultiBuyOption(
                                bodilyModificationOption = option,
                                boughtTimes = state.quantity,
                                maxBuyTimes = multiBuy.max,
                                canBuyMore = multiBuy.max?.let { state.quantity < it } ?: true,
                            )
                        }

                        upgrade != null -> {
                            val text = option.upgradeText
                            if(text == null) {
                                BodilyModificationExtraState.EmptyOption
                            } else {
                                val enabled = option.bodilyModification.upgradeRequirements(context)
                                BodilyModificationExtraState.UpgradeOption(
                                    bodilyModificationOption = option,
                                    upgradeText = text,
                                    upgradeEnabled = enabled,
                                    upgradeSelected = enabled && state.upgraded,
                                )
                            }

                        }

                        else -> {
                            BodilyModificationExtraState.EmptyOption
                        }
                    }

                    item to extra
                }
                .chunked(3)
                .flatMap { row ->
                    listOfNotNull(
                        BodilyModificationsSelectionState.Row.ChoicesRow(row.map { it.first }),
                        row.map { it.second }
                            .takeIf { it.filterIsInstance<BodilyModificationExtraState.EmptyOption>().isNotEmpty() }
                            ?.let { BodilyModificationsSelectionState.Row.ExtrasRow(it) },
                    )
                }

            scope.setState { BodilyModificationsSelectionState(options) }
        }
    }
}
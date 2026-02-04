package com.nsfwcyoamaker.cotdr.presentation.components.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.SectionSeparator
import com.nsfwcyoamaker.cotdr.presentation.components.sections.rulings.*
import com.nsfwcyoamaker.cotdr.presentation.model.FollowersRulingOption
import com.nsfwcyoamaker.cotdr.presentation.model.RulingOption
import com.nsfwcyoamaker.cotdr.presentation.model.RulingState
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.rulings.RulingsSelectionAction
import org.jetbrains.compose.ui.tooling.preview.Preview

fun LazyListScope.MainPage7(
    rulingStateProvider: @Composable (RulingOption.Option) -> RulingState.RulingOptionState,
    onRulingAction: (RulingsSelectionAction) -> Unit,
) {
    item(
        key = "RulingsPrelude",
        contentType = "RulingsPrelude",
    ) { RulingsPrelude() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "RulingsTitle",
        contentType = "RulingsTitle",
    ) { RulingsTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "RulingsDescriptionPart1",
        contentType = "RulingsDescriptionPart1",
    ) { RulingsDescriptionPart1() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "SectionSeparator",
        contentType = "SectionSeparator",
    ) { SectionSeparator() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "RulingsDescriptionPart2",
        contentType = "RulingsDescriptionPart2",
    ) { RulingsDescriptionPart2() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "FollowersRulingsSubTitle",
        contentType = "FollowersRulingsSubTitle",
    ) { FollowersRulingsSubTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "FollowersRulingsGrid",
        contentType = "FollowersRulingsGrid",
    ) {
        FollowersRulingsGrid(
            rulingStateProvider = rulingStateProvider,
            onRulingAction = onRulingAction,
        )
    }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    //todo
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun MainPage7Preview() {
    AppScope {
        MainScreenList {
            MainPage7(
                { _ -> RulingState.RulingOptionState(FollowersRulingOption.TheFirstOfMany.devoted) },
                {},
            )
        }
    }
}
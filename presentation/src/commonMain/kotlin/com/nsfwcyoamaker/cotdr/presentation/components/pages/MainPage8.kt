package com.nsfwcyoamaker.cotdr.presentation.components.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.sections.rulings.*
import com.nsfwcyoamaker.cotdr.presentation.model.FollowersRulingOption
import com.nsfwcyoamaker.cotdr.presentation.model.RulingOption
import com.nsfwcyoamaker.cotdr.presentation.model.RulingState
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenList
import com.nsfwcyoamaker.cotdr.presentation.screens.rulings.RulingsSelectionAction
import org.jetbrains.compose.ui.tooling.preview.Preview

fun LazyListScope.MainPage8(
    rulingStateProvider: @Composable (RulingOption.Option) -> RulingState.RulingOptionState,
    onRulingAction: (RulingsSelectionAction) -> Unit,
) {
    item(
        key = "RulingsInterlude",
        contentType = "RulingsInterlude",
    ) { RulingsInterlude() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "BelieversRulingsSubTitle",
        contentType = "BelieversRulingsSubTitle",
    ) { BelieversRulingsSubTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "BelieversRulingsGrid",
        contentType = "BelieversRulingsGrid",
    ) {
        BelieversRulingsGrid(
            rulingStateProvider = rulingStateProvider,
            onRulingAction = onRulingAction,
        )
    }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "DevoteesRulingsSubTitle",
        contentType = "DevoteesRulingsSubTitle",
    ) { DevoteesRulingsSubTitle() }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "DevoteesRulingsGrid",
        contentType = "DevoteesRulingsGrid",
    ) {
        DevoteesRulingsGrid(
            rulingStateProvider = rulingStateProvider,
            onRulingAction = onRulingAction,
        )
    }

    item { Spacer(modifier = Modifier.height(12.dp)) }

    item(
        key = "RulingsExtra",
        contentType = "RulingsExtra",
    ) { RulingsExtra() }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun MainPage8Preview() {
    AppScope {
        MainScreenList {
            MainPage8(
                { _ -> RulingState.RulingOptionState(FollowersRulingOption.TheFirstOfMany.devoted) },
                {},
            )
        }
    }
}
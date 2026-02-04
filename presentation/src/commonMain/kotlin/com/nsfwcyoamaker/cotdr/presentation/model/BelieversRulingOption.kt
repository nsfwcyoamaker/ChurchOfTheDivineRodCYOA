package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.BelieversRuling
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class BelieversRulingOption(
    override val choice: BelieversRuling,
    override val title: StringResource,
    override val description: StringResource,
    val relaxedTitle: StringResource,
    val relaxedDescription: StringResource,
    val relaxedImage: DrawableResource,
    val neutralTitle: StringResource,
    val neutralDescription: StringResource,
    val neutralImage: DrawableResource,
    val devotedTitle: StringResource,
    val devotedDescription: StringResource,
    val devotedImage: DrawableResource,
): RulingOption {
    ActsOfService(
        choice = BelieversRuling.ActsOfService,
        title = Res.string.section_rulings_believers_rod_title,
        description = Res.string.section_rulings_believers_rod_description,
        relaxedTitle = Res.string.section_rulings_believers_rod_left_title,
        relaxedDescription = Res.string.section_rulings_believers_rod_left_description,
        relaxedImage = Res.drawable.ruling_believer_rod_left,
        neutralTitle = Res.string.section_rulings_believers_rod_middle_title,
        neutralDescription = Res.string.section_rulings_believers_rod_middle_description,
        neutralImage = Res.drawable.ruling_believer_rod_middle,
        devotedTitle = Res.string.section_rulings_believers_rod_right_title,
        devotedDescription = Res.string.section_rulings_believers_rod_right_description,
        devotedImage = Res.drawable.ruling_believer_rod_right,
    ),
    WhatTheHeartsWants(
        choice = BelieversRuling.WhatTheHeartsWants,
        title = Res.string.section_rulings_believers_love_title,
        description = Res.string.section_rulings_believers_love_description,
        relaxedTitle = Res.string.section_rulings_believers_love_left_title,
        relaxedDescription = Res.string.section_rulings_believers_love_left_description,
        relaxedImage = Res.drawable.ruling_believer_love_left,
        neutralTitle = Res.string.section_rulings_believers_love_middle_title,
        neutralDescription = Res.string.section_rulings_believers_love_middle_description,
        neutralImage = Res.drawable.ruling_believer_love_middle,
        devotedTitle = Res.string.section_rulings_believers_love_right_title,
        devotedDescription = Res.string.section_rulings_believers_love_right_description,
        devotedImage = Res.drawable.ruling_believer_love_right,
    ),
    AllForOneAndOneForAll(
        choice = BelieversRuling.AllForOneAndOneForAll,
        title = Res.string.section_rulings_believers_group_title,
        description = Res.string.section_rulings_believers_group_description,
        relaxedTitle = Res.string.section_rulings_believers_group_left_title,
        relaxedDescription = Res.string.section_rulings_believers_group_left_description,
        relaxedImage = Res.drawable.ruling_believer_group_left,
        neutralTitle = Res.string.section_rulings_believers_group_middle_title,
        neutralDescription = Res.string.section_rulings_believers_group_middle_description,
        neutralImage = Res.drawable.ruling_believer_group_middle,
        devotedTitle = Res.string.section_rulings_believers_group_right_title,
        devotedDescription = Res.string.section_rulings_believers_group_right_description,
        devotedImage = Res.drawable.ruling_believer_group_right,
    ),
    ShadesOfEnthusiasm(
        choice = BelieversRuling.ShadesOfEnthusiasm,
        title = Res.string.section_rulings_believers_decorum_title,
        description = Res.string.section_rulings_believers_decorum_description,
        relaxedTitle = Res.string.section_rulings_believers_decorum_left_title,
        relaxedDescription = Res.string.section_rulings_believers_decorum_left_description,
        relaxedImage = Res.drawable.ruling_believer_decorum_left,
        neutralTitle = Res.string.section_rulings_believers_decorum_middle_title,
        neutralDescription = Res.string.section_rulings_believers_decorum_middle_description,
        neutralImage = Res.drawable.ruling_believer_decorum_middle,
        devotedTitle = Res.string.section_rulings_believers_decorum_right_title,
        devotedDescription = Res.string.section_rulings_believers_decorum_right_description,
        devotedImage = Res.drawable.ruling_believer_decorum_right,
    );

    override val relaxed = RulingOption.Relaxed(
        rulingOption = this,
        title = relaxedTitle,
        description = relaxedDescription,
        image = relaxedImage
    )

    override val neutral = RulingOption.Neutral(
        rulingOption = this,
        title = neutralTitle,
        description = neutralDescription,
        image = neutralImage
    )

    override val devoted = RulingOption.Devoted(
        rulingOption = this,
        title = devotedTitle,
        description = devotedDescription,
        image = devotedImage
    )
}
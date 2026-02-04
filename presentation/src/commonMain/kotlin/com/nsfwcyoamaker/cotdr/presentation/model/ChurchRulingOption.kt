package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.ChurchRuling
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class ChurchRulingOption(
    override val choice: ChurchRuling,
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
    SpreadingTheWord(
        choice = ChurchRuling.SpreadingTheWord,
        title = Res.string.section_rulings_church_spread_title,
        description = Res.string.section_rulings_church_spread_description,
        relaxedTitle = Res.string.section_rulings_church_spread_left_title,
        relaxedDescription = Res.string.section_rulings_church_spread_left_description,
        relaxedImage = Res.drawable.ruling_church_spread_left,
        neutralTitle = Res.string.section_rulings_church_spread_middle_title,
        neutralDescription = Res.string.section_rulings_church_spread_middle_description,
        neutralImage = Res.drawable.ruling_church_spread_middle,
        devotedTitle = Res.string.section_rulings_church_spread_right_title,
        devotedDescription = Res.string.section_rulings_church_spread_right_description,
        devotedImage = Res.drawable.ruling_church_spread_right,
    ),
    TheFaceOfTheChurch(
        choice = ChurchRuling.TheFaceOfTheChurch,
        title = Res.string.section_rulings_church_holy_title,
        description = Res.string.section_rulings_church_holy_description,
        relaxedTitle = Res.string.section_rulings_church_holy_left_title,
        relaxedDescription = Res.string.section_rulings_church_holy_left_description,
        relaxedImage = Res.drawable.ruling_church_holy_left,
        neutralTitle = Res.string.section_rulings_church_holy_middle_title,
        neutralDescription = Res.string.section_rulings_church_holy_middle_description,
        neutralImage = Res.drawable.ruling_church_holy_middle,
        devotedTitle = Res.string.section_rulings_church_holy_right_title,
        devotedDescription = Res.string.section_rulings_church_holy_right_description,
        devotedImage = Res.drawable.ruling_church_holy_right,
    ),
    TheLimitsOfMatrimony(
        choice = ChurchRuling.TheLimitsOfMatrimony,
        title = Res.string.section_rulings_church_marriage_title,
        description = Res.string.section_rulings_church_marriage_description,
        relaxedTitle = Res.string.section_rulings_church_marriage_left_title,
        relaxedDescription = Res.string.section_rulings_church_marriage_left_description,
        relaxedImage = Res.drawable.ruling_church_marriage_left,
        neutralTitle = Res.string.section_rulings_church_marriage_middle_title,
        neutralDescription = Res.string.section_rulings_church_marriage_middle_description,
        neutralImage = Res.drawable.ruling_church_marriage_middle,
        devotedTitle = Res.string.section_rulings_church_marriage_right_title,
        devotedDescription = Res.string.section_rulings_church_marriage_right_description,
        devotedImage = Res.drawable.ruling_church_marriage_right,
    ),
    SoftTouchStringFist(
        choice = ChurchRuling.SoftTouchStringFist,
        title = Res.string.section_rulings_church_focus_title,
        description = Res.string.section_rulings_church_focus_description,
        relaxedTitle = Res.string.section_rulings_church_focus_left_title,
        relaxedDescription = Res.string.section_rulings_church_focus_left_description,
        relaxedImage = Res.drawable.ruling_church_focus_left,
        neutralTitle = Res.string.section_rulings_church_focus_middle_title,
        neutralDescription = Res.string.section_rulings_church_focus_middle_description,
        neutralImage = Res.drawable.ruling_church_focus_middle,
        devotedTitle = Res.string.section_rulings_church_focus_right_title,
        devotedDescription = Res.string.section_rulings_church_focus_right_description,
        devotedImage = Res.drawable.ruling_church_focus_right,
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
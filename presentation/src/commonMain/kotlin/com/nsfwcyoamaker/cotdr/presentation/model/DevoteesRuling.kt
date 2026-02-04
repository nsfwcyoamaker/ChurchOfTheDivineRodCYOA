package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.DevoteesRuling
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class DevoteesRulingOption(
    override val choice: DevoteesRuling,
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
    TheMortalRod(
        choice = DevoteesRuling.TheMortalRod,
        title = Res.string.section_rulings_devotees_dicks_title,
        description = Res.string.section_rulings_devotees_dicks_description,
        relaxedTitle = Res.string.section_rulings_devotees_dicks_left_title,
        relaxedDescription = Res.string.section_rulings_devotees_dicks_left_description,
        relaxedImage = Res.drawable.ruling_devotee_dicks_left,
        neutralTitle = Res.string.section_rulings_devotees_dicks_middle_title,
        neutralDescription = Res.string.section_rulings_devotees_dicks_middle_description,
        neutralImage = Res.drawable.ruling_devotee_dicks_middle,
        devotedTitle = Res.string.section_rulings_devotees_dicks_right_title,
        devotedDescription = Res.string.section_rulings_devotees_dicks_right_description,
        devotedImage = Res.drawable.ruling_devotee_dicks_right,
    ),
    PracticeMakesPerfect(
        choice = DevoteesRuling.PracticeMakesPerfect,
        title = Res.string.section_rulings_devotees_outsiders_title,
        description = Res.string.section_rulings_devotees_outsiders_description,
        relaxedTitle = Res.string.section_rulings_devotees_outsiders_left_title,
        relaxedDescription = Res.string.section_rulings_devotees_outsiders_left_description,
        relaxedImage = Res.drawable.ruling_devotee_outsiders_left,
        neutralTitle = Res.string.section_rulings_devotees_outsiders_middle_title,
        neutralDescription = Res.string.section_rulings_devotees_outsiders_middle_description,
        neutralImage = Res.drawable.ruling_devotee_outsiders_middle,
        devotedTitle = Res.string.section_rulings_devotees_outsiders_right_title,
        devotedDescription = Res.string.section_rulings_devotees_outsiders_right_description,
        devotedImage = Res.drawable.ruling_devotee_outsiders_right,
    ),
    FellowshipAndFondness(
        choice = DevoteesRuling.FellowshipAndFondness,
        title = Res.string.section_rulings_devotees_sisters_title,
        description = Res.string.section_rulings_devotees_sisters_description,
        relaxedTitle = Res.string.section_rulings_devotees_sisters_left_title,
        relaxedDescription = Res.string.section_rulings_devotees_sisters_left_description,
        relaxedImage = Res.drawable.ruling_devotee_sisters_left,
        neutralTitle = Res.string.section_rulings_devotees_sisters_middle_title,
        neutralDescription = Res.string.section_rulings_devotees_sisters_middle_description,
        neutralImage = Res.drawable.ruling_devotee_sisters_middle,
        devotedTitle = Res.string.section_rulings_devotees_sisters_right_title,
        devotedDescription = Res.string.section_rulings_devotees_sisters_right_description,
        devotedImage = Res.drawable.ruling_devotee_sisters_right,
    ),
    AspirationOfDevotion(
        choice = DevoteesRuling.AspirationOfDevotion,
        title = Res.string.section_rulings_devotees_identity_title,
        description = Res.string.section_rulings_devotees_identity_description,
        relaxedTitle = Res.string.section_rulings_devotees_identity_left_title,
        relaxedDescription = Res.string.section_rulings_devotees_identity_left_description,
        relaxedImage = Res.drawable.ruling_devotee_identity_left,
        neutralTitle = Res.string.section_rulings_devotees_identity_middle_title,
        neutralDescription = Res.string.section_rulings_devotees_identity_middle_description,
        neutralImage = Res.drawable.ruling_devotee_identity_middle,
        devotedTitle = Res.string.section_rulings_devotees_identity_right_title,
        devotedDescription = Res.string.section_rulings_devotees_identity_right_description,
        devotedImage = Res.drawable.ruling_devotee_identity_right,
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
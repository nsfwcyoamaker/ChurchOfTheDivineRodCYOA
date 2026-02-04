package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.FollowersRuling
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class FollowersRulingOption(
    override val choice: FollowersRuling,
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
    ShapeOfSex(
        choice = FollowersRuling.ShapeOfSex,
        title = Res.string.section_rulings_followers_sex_title,
        description = Res.string.section_rulings_followers_sex_description,
        relaxedTitle = Res.string.section_rulings_followers_sex_left_title,
        relaxedDescription = Res.string.section_rulings_followers_sex_left_description,
        relaxedImage = Res.drawable.ruling_followers_sex_left,
        neutralTitle = Res.string.section_rulings_followers_sex_middle_title,
        neutralDescription = Res.string.section_rulings_followers_sex_middle_description,
        neutralImage = Res.drawable.ruling_followers_sex_middle,
        devotedTitle = Res.string.section_rulings_followers_sex_right_title,
        devotedDescription = Res.string.section_rulings_followers_sex_right_description,
        devotedImage = Res.drawable.ruling_followers_sex_right,
    ),ThePathLessWalked(
        choice = FollowersRuling.ThePathLessWalked,
        title = Res.string.section_rulings_followers_yuri_title,
        description = Res.string.section_rulings_followers_yuri_description,
        relaxedTitle = Res.string.section_rulings_followers_yuri_left_title,
        relaxedDescription = Res.string.section_rulings_followers_yuri_left_description,
        relaxedImage = Res.drawable.ruling_followers_yuri_left,
        neutralTitle = Res.string.section_rulings_followers_yuri_middle_title,
        neutralDescription = Res.string.section_rulings_followers_yuri_middle_description,
        neutralImage = Res.drawable.ruling_followers_yuri_middle,
        devotedTitle = Res.string.section_rulings_followers_yuri_right_title,
        devotedDescription = Res.string.section_rulings_followers_yuri_right_description,
        devotedImage = Res.drawable.ruling_followers_yuri_right,
    ),
    TheFemininePenis(
        choice = FollowersRuling.TheFemininePenis,
        title = Res.string.section_rulings_followers_futa_title,
        description = Res.string.section_rulings_followers_futa_description,
        relaxedTitle = Res.string.section_rulings_followers_futa_left_title,
        relaxedDescription = Res.string.section_rulings_followers_futa_left_description,
        relaxedImage = Res.drawable.ruling_followers_futa_left,
        neutralTitle = Res.string.section_rulings_followers_futa_middle_title,
        neutralDescription = Res.string.section_rulings_followers_futa_middle_description,
        neutralImage = Res.drawable.ruling_followers_futa_middle,
        devotedTitle = Res.string.section_rulings_followers_futa_right_title,
        devotedDescription = Res.string.section_rulings_followers_futa_right_description,
        devotedImage = Res.drawable.ruling_followers_futa_right,
    ),
    TheFirstOfMany(
        choice = FollowersRuling.TheFirstOfMany,
        title = Res.string.section_rulings_followers_virgin_title,
        description = Res.string.section_rulings_followers_virgin_description,
        relaxedTitle = Res.string.section_rulings_followers_virgin_left_title,
        relaxedDescription = Res.string.section_rulings_followers_virgin_left_description,
        relaxedImage = Res.drawable.ruling_followers_virgin_left,
        neutralTitle = Res.string.section_rulings_followers_virgin_middle_title,
        neutralDescription = Res.string.section_rulings_followers_virgin_middle_description,
        neutralImage = Res.drawable.ruling_followers_virgin_middle,
        devotedTitle = Res.string.section_rulings_followers_virgin_right_title,
        devotedDescription = Res.string.section_rulings_followers_virgin_right_description,
        devotedImage = Res.drawable.ruling_followers_virgin_right,
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
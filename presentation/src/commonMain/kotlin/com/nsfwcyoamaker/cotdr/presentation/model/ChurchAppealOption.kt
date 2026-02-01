package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.ChurchAppeal
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class ChurchAppealOption(
    override val choice: ChurchAppeal,
    val image: DrawableResource,
    val title: StringResource,
    val description: StringResource,
    val effect: StringResource,
    val comment: StringResource,
): UiOption {
    HardNo(
        choice = ChurchAppeal.HardNo,
        image = Res.drawable.section_church_appeal_hard_no,
        title = Res.string.section_church_appeal_hard_no_title,
        description = Res.string.section_church_appeal_hard_no_description,
        effect = Res.string.section_church_appeal_hard_no_effect,
        comment = Res.string.section_church_appeal_hard_no_comment,

    ),
    LiveAndLetLive(
        ChurchAppeal.LiveAndLetLive,
        Res.drawable.section_church_appeal_live_and_let_live,
        title = Res.string.section_church_appeal_live_and_let_live_title,
        description = Res.string.section_church_appeal_live_and_let_live_description,
        effect = Res.string.section_church_appeal_live_and_let_live_effect,
        comment = Res.string.section_church_appeal_live_and_let_live_comment,
    ),
    WellMaybe(
        ChurchAppeal.WellMaybe,
        Res.drawable.section_church_appeal_well_maybe,
        title = Res.string.section_church_appeal_well_maybe_title,
        description = Res.string.section_church_appeal_well_maybe_description,
        effect = Res.string.section_church_appeal_well_maybe_effect,
        comment = Res.string.section_church_appeal_well_maybe_comment,
    );
}
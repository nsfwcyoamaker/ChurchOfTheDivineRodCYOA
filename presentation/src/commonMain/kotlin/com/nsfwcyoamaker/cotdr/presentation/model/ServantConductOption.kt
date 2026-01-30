package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.ConductType
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class ServantConductOption(
    val type: ConductType,
    val title: StringResource,
    val description: StringResource,
    val cost: StringResource,
    val image: DrawableResource,
) {
    Unrestrained(
        type = ConductType.Unrestrained,
        title = Res.string.servant_conduct_unrestrained_title,
        description = Res.string.servant_conduct_unrestrained_description,
        cost = Res.string.servant_conduct_unrestrained_cost,
        image = Res.drawable.servant_conduct_unrestrained,
    ),
    Aligned(
        type = ConductType.Aligned,
        title = Res.string.servant_conduct_aligned_title,
        description = Res.string.servant_conduct_aligned_description,
        cost = Res.string.servant_conduct_aligned_cost,
        image = Res.drawable.servant_conduct_aligned,
    ),
    Subjugated(
        type = ConductType.Subjugated,
        title = Res.string.servant_conduct_subjugated_title,
        description = Res.string.servant_conduct_subjugated_description,
        cost = Res.string.servant_conduct_subjugated_cost,
        image = Res.drawable.servant_conduct_subjugated,
    );
}
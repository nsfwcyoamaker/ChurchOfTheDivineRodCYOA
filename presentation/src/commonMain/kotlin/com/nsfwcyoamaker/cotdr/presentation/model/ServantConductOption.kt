package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class ServantConductOption(
    val title: StringResource,
    val description: StringResource,
    val image: DrawableResource,
) {
    Unrestrained(
        title = Res.string.servant_conduct_unrestrained_title,
        description = Res.string.servant_conduct_unrestrained_description,
        image = Res.drawable.servant_conduct_unrestrained,
    ),
    Aligned(
        title = Res.string.servant_conduct_aligned_title,
        description = Res.string.servant_conduct_aligned_description,
        image = Res.drawable.servant_conduct_aligned,
    ),
    Subjugated(
        title = Res.string.servant_conduct_subjugated_title,
        description = Res.string.servant_conduct_subjugated_description,
        image = Res.drawable.servant_conduct_subjugated,
    );
}
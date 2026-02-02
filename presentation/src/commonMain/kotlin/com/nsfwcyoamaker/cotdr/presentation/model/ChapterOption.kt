package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class ChapterOption(
    val title: StringResource,
    val description: StringResource,
    val image: DrawableResource,
    val doctrines: List<Doctrine>,
    val comment: StringResource,
    val tenets: List<Tenet>,
) {
    GuidingLight(
        title = Res.string.chapter_guiding_light_title,
        description = Res.string.chapter_guiding_light_description,
        image = Res.drawable.chapters_guiding_light_main,
        doctrines = listOf(
            Doctrine(
                title = Res.string.chapter_guiding_light_doctrine_1_title,
                description = Res.string.chapter_guiding_light_doctrine_1_description,
            ),
            Doctrine(
                title = Res.string.chapter_guiding_light_doctrine_2_title,
                description = Res.string.chapter_guiding_light_doctrine_2_description,
            ),
        ),
        comment = Res.string.chapter_guiding_light_comment,
        tenets = listOf(
            Tenet(
                title = Res.string.chapter_guiding_light_tenet_divine_diplomacy_title,
                description = Res.string.chapter_guiding_light_tenet_divine_diplomacy_description,
                image = Res.drawable.chapters_guiding_light_diplomacy,
            ),
            Tenet(
                title = Res.string.chapter_guiding_light_tenet_paper_pushing_title,
                description = Res.string.chapter_guiding_light_tenet_paper_pushing_description,
                image = Res.drawable.chapters_guiding_light_paperwork,
            ),
            Tenet(
                title = Res.string.chapter_guiding_light_tenet_closeness_title,
                description = Res.string.chapter_guiding_light_tenet_closeness_description,
                image = Res.drawable.chapters_guiding_light_skinship,
            ),
        )
    ),
    ArdentBlades(
        title = Res.string.chapter_ardent_blades_title,
        description = Res.string.chapter_ardent_blades_description,
        image = Res.drawable.chapters_ardent_blades_main,
        doctrines = listOf(
            Doctrine(
                title = Res.string.chapter_ardent_blades_doctrine_1_title,
                description = Res.string.chapter_ardent_blades_doctrine_1_description,
            ),
            Doctrine(
                title = Res.string.chapter_ardent_blades_doctrine_2_title,
                description = Res.string.chapter_ardent_blades_doctrine_2_description,
            ),
        ),
        comment = Res.string.chapter_ardent_blades_comment,
        tenets = listOf(
            Tenet(
                title = Res.string.chapter_ardent_blades_tenet_sound_body_title,
                description = Res.string.chapter_ardent_blades_tenet_sound_body_description,
                image = Res.drawable.chapters_ardent_blades_body,
            ),
            Tenet(
                title = Res.string.chapter_ardent_blades_tenet_fire_within_title,
                description = Res.string.chapter_ardent_blades_tenet_fire_within_description,
                image = Res.drawable.chapters_ardent_blades_yuri,
            ),
            Tenet(
                title = Res.string.chapter_ardent_blades_tenet_bearing_banner_title,
                description = Res.string.chapter_ardent_blades_tenet_bearing_banner_description,
                image = Res.drawable.chapters_ardent_blades_skimpy,
            ),
        )
    ),
    VauntedTruth(
        title = Res.string.chapter_vaunted_truth_title,
        description = Res.string.chapter_vaunted_truth_description,
        image = Res.drawable.chapters_vaunted_truth_main,
        doctrines = listOf(
            Doctrine(
                title = Res.string.chapter_vaunted_truth_doctrine_1_title,
                description = Res.string.chapter_vaunted_truth_doctrine_1_description,
            ),
            Doctrine(
                title = Res.string.chapter_vaunted_truth_doctrine_2_title,
                description = Res.string.chapter_vaunted_truth_doctrine_2_description,
            ),
        ),
        comment = Res.string.chapter_vaunted_truth_comment,
        tenets = listOf(
            Tenet(
                title = Res.string.chapter_vaunted_truth_tenet_bearing_witness_title,
                description = Res.string.chapter_vaunted_truth_tenet_bearing_witness_description,
                image = Res.drawable.chapters_vaunted_truth_witness,
            ),
            Tenet(
                title = Res.string.chapter_vaunted_truth_tenet_divine_spellcraft_title,
                description = Res.string.chapter_vaunted_truth_tenet_divine_spellcraft_description,
                image = Res.drawable.chapters_vaunted_truth_magic,
            ),
            Tenet(
                title = Res.string.chapter_vaunted_truth_tenet_dedication_title,
                description = Res.string.chapter_vaunted_truth_tenet_dedication_description,
                image = Res.drawable.chapters_vaunted_truth_dedication,
            ),
        )
    ),
    VividSplendor(
        title = Res.string.chapter_vivid_splendor_title,
        description = Res.string.chapter_vivid_splendor_description,
        image = Res.drawable.chapters_vivid_splendor_main,
        doctrines = listOf(
            Doctrine(
                title = Res.string.chapter_vivid_splendor_doctrine_1_title,
                description = Res.string.chapter_vivid_splendor_doctrine_1_description,
            ),
            Doctrine(
                title = Res.string.chapter_vivid_splendor_doctrine_2_title,
                description = Res.string.chapter_vivid_splendor_doctrine_2_description,
            ),
        ),
        comment = Res.string.chapter_vivid_splendor_comment,
        tenets = listOf(
            Tenet(
                title = Res.string.chapter_vivid_splendor_tenet_gospel_title,
                description = Res.string.chapter_vivid_splendor_tenet_gospel_description,
                image = Res.drawable.chapters_vivid_splendor_preaching,
            ),
            Tenet(
                title = Res.string.chapter_vivid_splendor_tenet_inscriptionists_title,
                description = Res.string.chapter_vivid_splendor_tenet_inscriptionists_description,
                image = Res.drawable.chapters_vivid_splendor_inscriptionist,
            ),
            Tenet(
                title = Res.string.chapter_vivid_splendor_tenet_expression_title,
                description = Res.string.chapter_vivid_splendor_tenet_expression_description,
                image = Res.drawable.chapters_vivid_splendor_expression,
            ),
        )
    ),
    CaptiveAllure(
        title = Res.string.chapter_captive_allure_title,
        description = Res.string.chapter_captive_allure_description,
        image = Res.drawable.chapters_captive_allure_main,
        doctrines = listOf(
            Doctrine(
                title = Res.string.chapter_captive_allure_doctrine_1_title,
                description = Res.string.chapter_captive_allure_doctrine_1_description,
            ),
            Doctrine(
                title = Res.string.chapter_captive_allure_doctrine_2_title,
                description = Res.string.chapter_captive_allure_doctrine_2_description,
            ),
        ),
        comment = Res.string.chapter_captive_allure_comment,
        tenets = listOf(
            Tenet(
                title = Res.string.chapter_captive_allure_tenet_outreach_title,
                description = Res.string.chapter_captive_allure_tenet_outreach_description,
                image = Res.drawable.chapters_captive_allure_outreach,
            ),
            Tenet(
                title = Res.string.chapter_captive_allure_tenet_missionaries_title,
                description = Res.string.chapter_captive_allure_tenet_missionaries_description,
                image = Res.drawable.chapters_captive_allure_missionaries,
            ),
            Tenet(
                title = Res.string.chapter_captive_allure_tenet_beguiling_title,
                description = Res.string.chapter_captive_allure_tenet_beguiling_description,
                image = Res.drawable.chapters_captive_allure_beguiling,
            ),
        )
    );

    data class Doctrine(
        val title: StringResource,
        val description: StringResource,
    )
    data class Tenet(
        val image: DrawableResource,
        val title: StringResource,
        val description: StringResource,
    )
}
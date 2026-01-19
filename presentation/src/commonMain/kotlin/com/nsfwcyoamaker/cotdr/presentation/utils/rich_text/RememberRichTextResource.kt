package com.nsfwcyoamaker.cotdr.presentation.utils.rich_text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun rememberRichTextResource(
    stringRes: StringResource,
    styles: Map<String, RichStyleTag> = LocalRichTextStyles.current
): AnnotatedString {
    val string = stringResource(stringRes)
    return remember(string) { string.smartTrim().parseRichText(styles) }
}
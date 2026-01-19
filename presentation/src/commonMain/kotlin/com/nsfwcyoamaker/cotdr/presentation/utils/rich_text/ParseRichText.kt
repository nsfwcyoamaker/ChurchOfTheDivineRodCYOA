package com.nsfwcyoamaker.cotdr.presentation.utils.rich_text

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString

fun String.parseRichText(
    handlers: Map<String, TagHandler>
): AnnotatedString {
    val text = this
    return buildAnnotatedString {
        val tagStack = ArrayDeque<TagInfo>()
        var currentIndex = 0

        // Same Regex as before: Matches <tag> or [tag] with attributes
        val tagRegex = Regex("""(?:<|\[)(/?)(\w+)([\s\S]*?)(?:>|\])""")

        tagRegex.findAll(text).forEach { matchResult ->
            val (fullMatch, closingSlash, tagName, rawAttrs) = matchResult.groupValues

            // 1. Append text before the tag
            if (matchResult.range.first > currentIndex) {
                append(text.substring(currentIndex, matchResult.range.first))
            }

            if (closingSlash.isNotBlank()) {
                // --- CLOSING TAG ---
                val lastOpenIndex = tagStack.indexOfLast { it.name == tagName }
                if (lastOpenIndex != -1) {
                    val tagInfo = tagStack.removeAt(lastOpenIndex)
                    val (span, paragraph) = tagInfo.style

                    // Apply SpanStyle (Color, Size, Bold)
                    if (span != null) {
                        addStyle(span, tagInfo.startIndex, length)
                    }
                    // Apply ParagraphStyle (Indents, Alignment)
                    if (paragraph != null) {
                        addStyle(paragraph, tagInfo.startIndex, length)
                    }
                }
            } else {
                // --- OPENING TAG ---
                val handler = handlers[tagName]
                if (handler != null) {
                    val attributes = parseAttributes(rawAttrs) // Use the helper from previous step
                    val style = handler.resolve(attributes)

                    if (style != null) {
                        tagStack.addLast(TagInfo(tagName, length, style))
                    }
                }
            }
            currentIndex = matchResult.range.last + 1
        }

        // 2. Append remaining text
        if (currentIndex < text.length) {
            append(text.substring(currentIndex))
        }
    }
}

private data class TagInfo(val name: String, val startIndex: Int, val style: RichTextStyle)

private fun parseAttributes(rawAttributes: String): Map<String, String> {
    if (rawAttributes.isBlank()) return emptyMap()

    val attributes = mutableMapOf<String, String>()
    // Matches: key="value" OR key='value' OR key=value
    val attrRegex = Regex("""(\w+)=["']?([^"'\s]+)["']?""")

    attrRegex.findAll(rawAttributes).forEach { match ->
        val key = match.groupValues[1]
        val value = match.groupValues[2]
        attributes[key] = value
    }
    return attributes
}
package com.nsfwcyoamaker.cotdr.composableRichText

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString

fun String.parseRichText(
    handlers: Map<String, TagHandler>
): AnnotatedString {
    val text = this
    return buildAnnotatedString {
        val tagStack = ArrayDeque<TagInfo>()
        val queuedStyles = mutableListOf<QueuedStyle>()
        var currentIndex = 0

        val tagRegex = Regex("""(?:<|\[)(/?)(\w+)([\s\S]*?)(?:>|\])""")

        tagRegex.findAll(text).forEach { matchResult ->
            val (fullMatch, closingSlash, tagName, rawAttrs) = matchResult.groupValues

            // 1. Append text before the tag
            if (matchResult.range.first > currentIndex) {
                append(text.substring(currentIndex, matchResult.range.first))
            }

            // Track if we just closed a tag that forces a new line (ParagraphStyle)
            var isParagraphClosing = false

            if (closingSlash.isNotBlank()) {
                // --- CLOSING TAG ---
                val lastOpenIndex = tagStack.indexOfLast { it.name == tagName }
                if (lastOpenIndex != -1) {
                    val tagInfo = tagStack.removeAt(lastOpenIndex)

                    // Check if this tag was a Paragraph Style
                    if (tagInfo.style.paragraphStyle != null) {
                        isParagraphClosing = true
                    }

                    queuedStyles.add(
                        QueuedStyle(
                            style = tagInfo.style,
                            start = tagInfo.startIndex,
                            end = length
                        )
                    )
                }
            } else {
                // --- OPENING TAG ---
                val handler = handlers[tagName]
                if (handler != null) {
                    val attributes = parseAttributes(rawAttrs) // helper function
                    val style = handler.resolve(attributes)
                    if (style != null) {
                        tagStack.addLast(TagInfo(tagName, length, style))
                    }
                }
            }

            // 2. Advance Current Index
            val endOfTagIndex = matchResult.range.last + 1

            // CRITICAL CHANGE:
            // If we just closed a paragraph tag AND the very next char is a newline, swallow it.
            if (isParagraphClosing && endOfTagIndex < text.length && text[endOfTagIndex] == '\n') {
                currentIndex = endOfTagIndex + 1
            } else {
                currentIndex = endOfTagIndex
            }
        }

        // 3. Append remaining text
        if (currentIndex < text.length) {
            append(text.substring(currentIndex))
        }

        // 4. Apply Styles (Sorted: Outer/Longest tags first)
        queuedStyles.sortByDescending { it.end - it.start }

        queuedStyles.forEach { item ->
            val (span, paragraph) = item.style

            if (span != null) {
                addStyle(span, item.start, item.end)
            }
            if (paragraph != null) {
                addStyle(paragraph, item.start, item.end)
            }
        }
    }
}

// Helper classes
private data class TagInfo(val name: String, val startIndex: Int, val style: RichTextStyle)
private data class QueuedStyle(val style: RichTextStyle, val start: Int, val end: Int)

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
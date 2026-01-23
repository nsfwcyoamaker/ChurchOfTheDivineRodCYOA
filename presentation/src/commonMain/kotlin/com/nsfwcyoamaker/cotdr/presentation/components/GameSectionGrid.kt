package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

inline fun <T> LazyListScope.ChoicesGrid(
    items: List<T>,
    columns: Int,
    key: Any,
    contentType: Any? = null,
    crossinline itemContent: @Composable BoxScope.(T) -> Unit,
    noinline extraContent: (@Composable BoxScope.(T) -> Unit)? = null,
) {
    val rows = items.chunked(columns)

    rows.forEachIndexed { rowIndex, rowItems ->
        item(
            key = "row_${key}_${rowIndex}",
            contentType = contentType,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)
                ) {
                    rowItems.forEach { item ->
                        Box(Modifier.weight(1f).fillMaxHeight()) {
                            itemContent(item)
                        }
                    }

                    if (rowItems.size < columns) {
                        Spacer(Modifier.weight((columns - rowItems.size).toFloat()))
                    }
                }

                if (extraContent != null) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier.fillMaxWidth().wrapContentHeight()
                    ) {
                        rowItems.forEach { item ->
                            Box(Modifier.weight(1f)) {
                                extraContent(item)
                            }
                        }
                        if (rowItems.size < columns) {
                            Spacer(Modifier.weight((columns - rowItems.size).toFloat()))
                        }
                    }
                }
            }
        }

        if (rowIndex < rows.lastIndex) {
            item { Spacer(Modifier.height(24.dp)) }
        }
    }
}
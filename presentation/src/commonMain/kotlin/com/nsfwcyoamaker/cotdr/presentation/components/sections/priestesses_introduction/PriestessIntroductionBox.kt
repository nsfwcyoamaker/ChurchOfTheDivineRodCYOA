package com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nsfwcyoamaker.cotdr.presentation.components.choiceContour
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroduction
import com.nsfwcyoamaker.cotdr.presentation.utils.rich_text.rememberRichTextResource
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
fun PriestessIntroductionBox(
    title: StringResource,
    image: DrawableResource,
    description: StringResource,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
        modifier = modifier.choiceContour()
    ) {
        Text(
            text = rememberRichTextResource(title),
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = false)
                .padding(horizontal = 18.dp),
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth()
                    .shadowBorder()
            )
        }

        Text(
            text = rememberRichTextResource(description),
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Color.White,
            ),
        )
    }
}

private object PriestessParameter: PreviewParameterProvider<PriestessIntroduction> {
    override val values: Sequence<PriestessIntroduction>
        get() = PriestessIntroduction.entries.asSequence()
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun PriestessIntroductionBoxPreview(
    @PreviewParameter(PriestessParameter::class) priestessIntroduction: PriestessIntroduction,
) {
    PriestessIntroductionBox(
        title = priestessIntroduction.title,
        image = priestessIntroduction.image,
        description = priestessIntroduction.description,
        modifier = Modifier
            .requiredWidth(300.dp)
            .wrapContentHeight()
    )
}
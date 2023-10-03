package com.hopcape.wallpapers.presentation.screen.onboarding.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Renders the pageIndicator onto the screen
 * @param selectePosition is the position to be highlighted
 * @param size the total pages in the indicator*/
@Composable
fun PageIndicator(
    selectedPosition: Int = 1,
    count: Int = 3,
    circleSize: Dp = 10.dp

) {
    Row {
        for (i in 0 until count){
            Box(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .size(
                        width = if (i == selectedPosition) circleSize + 16.dp else circleSize,
                        height = circleSize
                    )
                    .clip(shape = CircleShape)
                    .background(color = Color.White)
            )
        }
    }
}

@Preview
@Composable
fun PageIndicatorPreview() {
    PageIndicator()
}
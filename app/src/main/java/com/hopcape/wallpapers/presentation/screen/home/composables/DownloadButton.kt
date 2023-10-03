package com.hopcape.wallpapers.presentation.screen.home.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hopcape.wallpapers.R

/**
 * Circular button with the following attributes
 * @param modifier
 * @param iconResId - Icon
 * @param strokeWidth - Stroke size
 * @param strokeColor - Stroke Color
 * @param backgroundColor
 * @param tint - Icon Tint
 * @param onClick
 * */

@Composable
fun OutlinedCircularButton(
    modifier: Modifier = Modifier,
    iconResId: Int = R.drawable.arrow_down,
    strokeWidth: Dp = 1.dp,
    strokeColor: Color = Color.LightGray,
    backgroundColor: Color = Color.DarkGray,
    tint: Color = Color.White,
    onClick: () -> Unit = {},
    internalPadding: Dp = 8.dp
) {
    Box(modifier = modifier
        .padding(4.dp)
        .clip(
            shape = CircleShape
        )
        .border(
            border = BorderStroke(
                width = strokeWidth,
                color = strokeColor,
            ),
            shape = CircleShape
        )
        .background(color = backgroundColor)
        .clickable {
            onClick()
        }
        .padding(internalPadding),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = "",
            tint = tint
        )
    }
}

@Preview
@Composable
fun OutlinedCircularButtonPreview() {
    OutlinedCircularButton()
}
package com.hopcape.wallpapers.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hopcape.wallpapers.ui.theme.DarkYellow
import com.hopcape.wallpapers.ui.theme.GuardsMenRed
import com.hopcape.wallpapers.ui.theme.PurplishBlue


/**
 * Custom button with gradient
 * @param modifier
 * @param text - to be displayed
 * @param onClick - to be invoked when clicked
 * */
@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    text: String = "CONTINUE",
    onClick: () -> Unit = {},
    cornerRadius: Dp = 10.dp,
    buttonHeight: Dp = 50.dp
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(cornerRadius)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(buttonHeight)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            DarkYellow,
                            GuardsMenRed,
                            PurplishBlue
                        )
                    )
                )
                .padding(horizontal = 16.dp, vertical = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text)
        }
    }
}

@Preview
@Composable
fun GradientButtonPreview() {
    GradientButton()
}
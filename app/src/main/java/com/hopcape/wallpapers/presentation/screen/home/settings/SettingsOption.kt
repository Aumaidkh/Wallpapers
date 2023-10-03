package com.hopcape.wallpapers.presentation.screen.home.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hopcape.wallpapers.R
import com.hopcape.wallpapers.ui.theme.GradientColors

/**
 * Individual Option in Setting Screen
 * @param label - label to be shown
 * @param iconResId - icon to be shown
 * @param type - option type
 * */
data class SettingsOption(
    val label: Int,
    val iconResId: Int,
    val type: OptionType
)

enum class OptionType{
    TUTORIAL,
    RATE_US,
    SHARE
}

val options = listOf(
    SettingsOption(
        label = R.string.tutorial,
        iconResId = R.drawable.book,
        type = OptionType.TUTORIAL
    ),
    SettingsOption(
        label = R.string.rate_us,
        iconResId = R.drawable.star,
        type = OptionType.RATE_US
    ),
    SettingsOption(
        label = R.string.share,
        iconResId = R.drawable.share,
        type = OptionType.SHARE
    ),
)

@Composable
fun SettingsOption(
    modifier: Modifier = Modifier,
    option: SettingsOption = options.first()
) {
    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Icon with Label
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(32.dp)
                        .graphicsLayer(
                            alpha = 0.99f
                        )
                        .drawWithCache {
                            onDrawWithContent {
                                drawContent()
                                drawRect(
                                    brush = Brush.horizontalGradient(
                                        GradientColors,
                                    ),
                                    blendMode = BlendMode.SrcAtop
                                )
                            }
                        },
                    painter = painterResource(id = option.iconResId),
                    contentDescription = "Arrow",

                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = option.label),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                )
            }
            // Arrow Icon
            Icon(
                modifier = Modifier
                    .padding(8.dp)
                    .size(32.dp)
                    .graphicsLayer(
                        alpha = 0.99f
                    )
                    .drawWithCache {
                        onDrawWithContent {
                            drawContent()
                            drawRect(
                                brush = Brush.horizontalGradient(
                                    GradientColors,
                                ),
                                blendMode = BlendMode.SrcAtop
                            )
                        }
                    },
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Arrow",
            )
        }
        GradientDivider()
    }
}

@Composable
private fun GradientDivider() {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    GradientColors
                )
            )
            .height(1.dp)
            .fillMaxWidth(),

        )
}

@Preview
@Composable
fun SettingsOptionPreview() {
    SettingsOption()
}
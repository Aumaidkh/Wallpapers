package com.hopcape.wallpapers.presentation.screen.onboarding.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hopcape.wallpapers.presentation.composables.GradientButton
import com.hopcape.wallpapers.ui.theme.Jaguar

/**
 * Bottom Sheet to be shown in the onboarding flow
 * @param modifier
 * @param title - Heading to be shown
 * @param body - Body of the Bottom Sheet
 * @param onContinue - Invoked when continue button clicked
 * */
@Composable
fun OnBoardingBottomSheet(
    modifier: Modifier = Modifier,
    title: String = "Big Collection",
    body: String = "Find wallpapers for every taste and every mood in constantly updated collections",
    onContinue: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            )
            .background(color = Jaguar)
            .padding(horizontal = 24.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = title,
            color = Color.White,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 23.sp
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Body
        Text(
            text = body,
            color = Color.White,
            style = MaterialTheme
                .typography
                .bodyMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(40.dp))
        // Button
        GradientButton(
            modifier = Modifier
                .fillMaxWidth(),
            cornerRadius = 12.dp,
            onClick = onContinue
        )
    }
}

@Preview
@Composable
fun OnBoardingBottomSheetPeview() {
    OnBoardingBottomSheet()
}
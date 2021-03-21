package dev.gonz.compose.animations.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.gonz.compose.animations.ui.theme.ComposeAnimationsTheme

@Composable
fun InfiniteTransitionExample(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(initialValue = Color.Blue,
        targetValue = Color.Magenta,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse)
    )

    val rotationAngle by infiniteTransition.animateValue(
        initialValue = 0F,
        targetValue = 360F,
        typeConverter = TwoWayConverter(
            convertToVector = {
                AnimationVector1D(it)
            },
            convertFromVector = {
                it.value
            }
        ),
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Surface(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Remember Infinite Transition", fontSize = 28.sp)
            Box(modifier = Modifier
                .graphicsLayer(rotationZ = rotationAngle)
                .background(color)
                .size(100.dp))
        }
    }
}

@Composable
@Preview
fun Preview_InfiniteTransitionExample() {
    ComposeAnimationsTheme {
        InfiniteTransitionExample()
    }
}
package dev.gonz.compose.animations.animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.gonz.compose.animations.ui.theme.ComposeAnimationsTheme

@Composable
fun AnimatedFooAsStateExample(
    modifier: Modifier = Modifier
) {
    var rotate by remember { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        if (rotate) 360F else 0F,
        animationSpec = tween(durationMillis = 500)
    )
    Surface(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("animated*AsState", fontSize = 32.sp)
            Button(
                modifier = Modifier.padding(top = 20.dp, bottom = 30.dp),
                onClick = {
                    rotate = !rotate
                }
            ) {
                Text("Rotate now!")
            }
            Box(modifier = Modifier
                .graphicsLayer(rotationZ = rotationAngle)
                .padding(bottom = 16.dp)
                .size(100.dp)
                .background(Color.Magenta))
        }
    }
}

@Preview
@Composable
fun Preview_AnimatedFooAsStateExample() {
    ComposeAnimationsTheme {
        AnimatedFooAsStateExample()
    }
}
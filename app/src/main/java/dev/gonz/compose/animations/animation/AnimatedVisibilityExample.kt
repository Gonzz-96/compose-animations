package dev.gonz.compose.animations.animation

import androidx.compose.animation.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.gonz.compose.animations.ui.theme.ComposeAnimationsTheme

@ExperimentalAnimationApi
@Composable
fun AnimatedVisibilityExample(
    modifier: Modifier = Modifier
) {
    var visible by remember { mutableStateOf(true) }

    Surface(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Animated Visibility", fontSize = 32.sp)
            Button(
                onClick = { visible = !visible },
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .defaultMinSize(minWidth = 30.dp)
            ) {
                Text(if (visible) "Hide" else "Show")
            }
            // the 'enter' parameter type: EnterTransition
            // the 'exit' parameter type: ExitTransition
            AnimatedVisibility(
                visible = visible,
                enter = expandIn(),
                exit = shrinkOut()
            ) {
                Square(canvasSize = 200.dp)
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
@Preview(showBackground = true)
fun ComposablePreview() {
    ComposeAnimationsTheme {
        AnimatedVisibilityExample()
    }
}

@Composable
fun Square(
    canvasSize: Dp = 10.dp,
    color: Color = Color.Blue.copy(alpha = 0.8F)
) {
    Canvas(modifier = Modifier.size(canvasSize)) {
        drawRect(
            color = color,
            topLeft = Offset(0F, 0F),
            size = size
        )
    }
}

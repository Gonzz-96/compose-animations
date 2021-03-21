package dev.gonz.compose.animations.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateOffset
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.gonz.compose.animations.ui.theme.ComposeAnimationsTheme

private enum class BoxState {
    Big,
    Small,
}

@Composable
fun PackagedTransition(
    modifier: Modifier = Modifier
) {
    var boxState by remember { mutableStateOf(BoxState.Small) }
    val transitionData = updateTransitionData(boxState)

    Surface(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Animate!", fontSize = 32.sp)
            Button(
                modifier = Modifier.padding(top = 20.dp, bottom = 30.dp),
                onClick = {
                    boxState = if (boxState == BoxState.Small)
                        BoxState.Big
                    else
                        BoxState.Small
                }
            ) {
                Text("Move now!")
            }
            Box(modifier = Modifier
                .offset(transitionData.offset.x.dp, 0.dp)
                .background(transitionData.color)
                .size(100.dp))
        }
    }
}

@Composable
private fun updateTransitionData(boxState: BoxState): TransitionData {
    val transition = updateTransition(boxState)

    val color = transition.animateColor(
        transitionSpec = {
            tween(durationMillis = 1_000)
        }
    ) {
        when (it) {
            BoxState.Small -> Color.Red
            BoxState.Big -> Color.Green
        }
    }

    val size = transition.animateOffset(
        transitionSpec = {
            tween(durationMillis = 1_000)
        }
    ) {
        when (it) {
            BoxState.Small -> Offset(-100F, 0F)
            BoxState.Big -> Offset(100F, 0F)
        }
    }

    return remember { TransitionData(color, size) }
}

class TransitionData(
    color: State<Color>,
    offset: State<Offset>
) {
    val color by color
    val offset by offset
}

@Composable
@Preview
fun Preview_PackagedTransition() {
    ComposeAnimationsTheme {
        PackagedTransition(modifier = Modifier.width(500.dp))
    }
}
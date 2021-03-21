package dev.gonz.compose.animations.animation

import android.util.Log
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.gonz.compose.animations.ui.theme.ComposeAnimationsTheme

private enum class BoxPosition {
    TopRight,
    TopLeft,
    BottomRight,
    BottomLeft
}

@Composable
fun UpdateTransitionExample(
    modifier: Modifier = Modifier
) {
    var boxPosition by remember { mutableStateOf(BoxPosition.TopLeft) }
    val transition = updateTransition(targetState = boxPosition)

    val boxOffset = transition.animateOffset(
        transitionSpec = {
            tween(durationMillis = 1_000)
        }
    ) { position ->
        when (position) {
            BoxPosition.TopLeft -> Offset(0F, 0F)
            BoxPosition.BottomRight -> Offset(120F, 120F)
            BoxPosition.TopRight -> Offset(120F, 0F)
            BoxPosition.BottomLeft -> Offset(0F, 120F)
        }
    }
    
    Surface(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Update Transition", fontSize = 32.sp)
            Button(
                modifier = Modifier.padding(top = 20.dp, bottom = 30.dp),
                onClick = {
                    boxPosition = getNextPosition(boxPosition)
                }
            ) {
                Text("Rotate now!")
            }
            Box(modifier = Modifier
                .size(150.dp)
                .background(Color.Black)
            ) {
                Box(modifier = Modifier
                    .offset(boxOffset.value.x.dp, boxOffset.value.y.dp)
                    .size(30.dp)
                    .background(Color.Yellow))
            }
        }
    }
}

private fun getNextPosition(position: BoxPosition) =
    when (position) {
        BoxPosition.TopLeft -> BoxPosition.BottomRight
        BoxPosition.BottomRight -> BoxPosition.TopRight
        BoxPosition.TopRight -> BoxPosition.BottomLeft
        BoxPosition.BottomLeft -> BoxPosition.TopLeft
    }

@Composable
@Preview
fun Preview_UpdateTransitionExample() {
    ComposeAnimationsTheme {
        UpdateTransitionExample()
    }
}
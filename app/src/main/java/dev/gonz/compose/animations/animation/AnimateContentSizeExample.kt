package dev.gonz.compose.animations.animation

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.gonz.compose.animations.ui.theme.ComposeAnimationsTheme

// The `animateContentSize` is a state-driven animation.
// The animation will depend on the state of the composable.
@Composable
fun AnimateContentSizeExample(
    modifier: Modifier = Modifier
) {
    var size by remember { mutableStateOf(Size(100F, 100F)) }

    Surface(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Animate Content Size",
                fontSize = 32.sp,
                modifier = Modifier
                    .padding(vertical = 16.dp))
            Button(
                modifier = Modifier.padding(vertical = 20.dp),
                onClick = {
                    size = if (size.height == 100F)
                        Size(200F, 200F)
                    else
                        Size(100F, 100F)
                }
            ) {
                Text("Change size")
            }
            Box(
                modifier = Modifier
                    .animateContentSize()
                    .size(size.height.dp)
                    .background(Color.Red))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_AnimateContentSizeExample() {
    ComposeAnimationsTheme {
        AnimateContentSizeExample()
    }
}
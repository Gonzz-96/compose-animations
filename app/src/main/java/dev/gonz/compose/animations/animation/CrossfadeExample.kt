package dev.gonz.compose.animations.animation

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.gonz.compose.animations.ui.theme.ComposeAnimationsTheme

private enum class Text(val text: String) {
    TextA("Text A"),
    TextB("Text B"),
}

@Composable
fun CrossfadeExample(
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf(Text.TextA) }
    Surface(modifier = modifier.height(200.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Crossfade", fontSize = 32.sp)
            Button(
                modifier = Modifier.padding(vertical = 20.dp),
                onClick = {
                    text = when (text) {
                        Text.TextA -> Text.TextB
                        Text.TextB -> Text.TextA
                    }
                }
            ) {
                Text(text.text)
            }
            Crossfade(targetState = text, animationSpec = tween(1_000)) {
                when (it) {
                    Text.TextA -> Text(text = "This is my first text: ${it.text}", fontSize = 20.sp)
                    Text.TextB -> Text(text = "This is my second text: ${it.text}", fontSize = 20.sp)
                }
            }
        }
    }
}

@Composable
@Preview
fun Preview_CrossfadeExample() {
    ComposeAnimationsTheme {
        CrossfadeExample()
    }
}
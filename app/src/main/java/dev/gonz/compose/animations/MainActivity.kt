package dev.gonz.compose.animations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.gonz.compose.animations.animation.*
import dev.gonz.compose.animations.ui.theme.ComposeAnimationsTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                        item {
                            AnimatedVisibilityExample(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 20.dp))
                        }
                        item { Divider() }
                        item {
                            AnimateContentSizeExample(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 20.dp)
                            )
                        }
                        item { Divider() }
                        item {
                            CrossfadeExample(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 20.dp)
                            )
                        }
                        item { Divider() }
                        item {
                            AnimatedFooAsStateExample(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 20.dp)
                            )
                        }
                        item { Divider() }
                        item {
                            UpdateTransitionExample(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 20.dp)
                            )
                        }
                        item { Divider() }
                    }
                }
            }
        }
    }
}

@Composable
fun Divider() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .background(Color.Gray))
}
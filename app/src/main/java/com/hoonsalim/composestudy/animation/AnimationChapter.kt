package com.hoonsalim.composestudy.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hoonsalim.composestudy.Chapter
import com.hoonsalim.composestudy.R
import com.hoonsalim.composestudy.ui.theme.ComposeStudyTheme

class AnimationChapter: Chapter {
    override val titleStringResourceId = R.string.animation
    override val destination = "animation"

    @Composable
    override fun Page() {
        MainScreen()
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen() {
    var boxVisible by remember { mutableStateOf(true) }

    val onClick = { newState : Boolean ->
        boxVisible = newState
    }

    Column(
        Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Crossfade(
                targetState = boxVisible,
                animationSpec = tween(5000)
            ) { visible ->
                when (visible) {
                    true -> CustomButton(
                        text = "Hide",
                        targetState = false,
                        onClick = onClick,
                        bgColor = Color.Red
                    )
                    false -> CustomButton(
                        text = "Show",
                        targetState = true,
                        onClick = onClick,
                        bgColor = Color.Magenta
                    )
                }
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        AnimatedVisibility(
            modifier = Modifier.padding(bottom = 16.dp),
            visible = boxVisible,
            enter = EnterTransition.None,
            exit = ExitTransition.None
        ) {
            Row {
                Box(
                    Modifier
                        .animateEnterExit(
                            enter = fadeIn(animationSpec = tween(durationMillis = 5500)),
                            exit = fadeOut(animationSpec = tween(durationMillis = 5500))
                        )
                        .size(width = 150.dp, height = 150.dp)
                        .background(Color.Blue))
                Spacer(modifier = Modifier.width(20.dp))
                Box(
                    Modifier
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = tween(durationMillis = 5500)
                            ),
                            exit = slideOutVertically(
                                animationSpec = tween(durationMillis = 5500)
                            )
                        )
                        .size(width = 150.dp, height = 150.dp)
                        .background(Color.Red)
                )
            }
        }

        Row(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            AnimatedVisibility(
                visible = boxVisible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 150.dp, height = 150.dp)
                        .background(Color.Blue)
                )
            }

            AnimatedVisibility(
                visible = !boxVisible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 150.dp, height = 150.dp)
                        .background(Color.Red)
                )
            }
        }

        Row(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            AnimatedVisibility(
                visible = boxVisible,
                enter = fadeIn() + expandVertically() + scaleIn(),
                exit = fadeOut() + slideOutVertically()
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 150.dp, height = 150.dp)
                        .background(Color.Blue)
                )
            }

            AnimatedVisibility(
                visible = !boxVisible,
                enter = fadeIn() + expandHorizontally(),
                exit = fadeOut() + slideOutHorizontally()
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 150.dp, height = 150.dp)
                        .background(Color.Red)
                )
            }
        }
    }
}

@Composable
fun CustomButton(
    text: String,
    targetState: Boolean,
    onClick: (Boolean) -> Unit,
    bgColor: Color = Color.Blue
) {
    Button(
        onClick = { onClick(targetState) },
        colors= ButtonDefaults.buttonColors(
            backgroundColor = bgColor,
            contentColor = Color.White
        )
    ) {
        Text(text)
    }
}

@Preview(showBackground = true,  showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme() {
        MainScreen()
    }
}
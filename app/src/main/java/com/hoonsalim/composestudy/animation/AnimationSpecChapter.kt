package com.hoonsalim.composestudy.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hoonsalim.composestudy.Chapter
import com.hoonsalim.composestudy.R
import com.hoonsalim.composestudy.ui.components.TitleAndRow

@OptIn(ExperimentalAnimationApi::class)
class AnimationSpecChapter: Chapter {
    override val titleStringResourceId = R.string.animation_spec
    override val destination = "animation_spec"

    @Composable
    override fun Page() {
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
                    animationSpec = tween(3000)
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

            TitleAndRow(
                modifier = Modifier.padding(bottom = 16.dp),
                title = "tween"
            ){
                AnimatedVisibility(
                    visible = boxVisible,
                    enter = fadeIn(
                        animationSpec = tween(
                            durationMillis = 3000,
                            delayMillis = 1000,
                            //FastOutSlowInEasing, LinearOutSlowInEasing, FastOutLinearEasing, LinearEasing, CubicBezierEasing
                            easing = FastOutLinearInEasing,
                        )
                    ),
                    exit = fadeOut()
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 150.dp, height = 150.dp)
                            .background(Color.Blue)
                    )
                }
            }
        }
    }
}
package com.hoonsalim.composestudy.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TitleAndRow(
    modifier: Modifier,
    title: String,
    rowContent: @Composable RowScope.() -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h5
        )
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center
        ) {
            rowContent.invoke(this)
        }
    }
}
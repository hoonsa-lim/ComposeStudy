package com.hoonsalim.composestudy.viewmodel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MemoListScreen(
    modifier: Modifier,
    memos: String,
    onClickSave: (text: String) -> Unit,
) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            TextField(
                modifier = Modifier.weight(1.0f),
                value = text,
                onValueChange = { text = it }
            )
            Button(
                onClick = {
                    onClickSave.invoke(text)
                    text = ""
                }
            ) {
                Text(text = "Save")
            }
        }
        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .weight(1.0f),
            text = memos
        )
    }
}

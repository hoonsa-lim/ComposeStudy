package com.hoonsalim.composestudy.row_column

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hoonsalim.composestudy.Chapter
import com.hoonsalim.composestudy.R

class RowColumnChapter: Chapter {
    override val titleStringResourceId: Int = R.string.row_column
    override val destination: String = "row_column"

    @Composable
    override fun Page() {
        Scaffold(
            topBar = {
                TopAppBar(

                ) {
                    Text(
                        text = stringResource(id = titleStringResourceId)
                    )
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colors.primary,
                        )
                        .padding(16.dp)
                ) {
                    Item(
                        modifier = Modifier.background(color = Color.Gray)
                    )
                    Item(
                        modifier = Modifier.background(color = Color.Magenta)
                    )
                    Item(
                        modifier = Modifier.background(color = Color.Blue)
                    )
                }
            }
        }
    }

    @Composable
    private fun Item(
        modifier: Modifier = Modifier
    ){
        Text(
            text = "",
            modifier = modifier.size(100.dp),
        )
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
private fun DefaultPreView(){
    RowColumnChapter().Page()
}
package com.hoonsalim.composestudy.row_column

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
            Row (
                horizontalArrangement = Arrangement.Center
                    ){

            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                item {
                    RowItem(
                        title = "Arrangement.Start",
                        horizontalArrangement = Arrangement.Start,
                    )
                }
                item {
                    RowItem(
                        title = "Arrangement.End",
                        horizontalArrangement = Arrangement.End,
                    )
                }
                item {
                    RowItem(
                        title = "Arrangement.Center",
                        horizontalArrangement = Arrangement.Center,
                    )
                }
                item {
                    RowItem(
                        title = "Arrangement.SpaceEvenly",
                        horizontalArrangement = Arrangement.SpaceEvenly,
                    )
                }
                item {
                    RowItem(
                        title = "Arrangement.SpaceBetween",
                        horizontalArrangement = Arrangement.SpaceBetween,
                    )
                }
                item {
                    RowItem(
                        title = "Arrangement.SpaceAround",
                        horizontalArrangement = Arrangement.SpaceAround,
                    )
                }
                item {
                    RowItem(
                        title = "Arrangement.spacedBy(4.dp)",
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                    )
                }
                item {
                    RowItem(
                        title = "Alignment.CenterVertically",
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                    )
                }
                item {
                    RowItem(
                        title = "Alignment.Top",
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Top,
                    )
                }
                item {
                    RowItem(
                        title = "Alignment.Bottom",
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Bottom,
                    )
                }
                item {
                    ColumnItem(
                        title = "Arrangement.Start",
                        verticalArrangement = Arrangement.Top
                    )
                }
            }
        }
    }

    @Composable
    private fun ColumnItem(
        title: String,
        verticalArrangement: Arrangement.Vertical
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colors.primary,
                )
                .padding(16.dp),
            verticalArrangement = verticalArrangement,
        ) {
            Text(
                text = title,
                color = MaterialTheme.colors.onPrimary
            )
            Item(
                modifier = Modifier.background(color = Color.Green)
            )
            Item(
                modifier = Modifier.background(color = Color.Yellow)
            )
            Item(
                modifier = Modifier.background(color = Color.Red)
            )
        }
    }

    @Composable
    private fun RowItem(
        title: String,
        horizontalArrangement: Arrangement.Horizontal,
        verticalAlignment: Alignment.Vertical = Alignment.Top
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colors.primary,
                )
                .height(200.dp)
                .border(2.dp, color = MaterialTheme.colors.background)
                .padding(16.dp)
        ) {
            Text(
                text = title,
                color = MaterialTheme.colors.onPrimary
            )
            Row(
                modifier = Modifier.fillMaxWidth().weight(1.0f),
                horizontalArrangement = horizontalArrangement,
                verticalAlignment = verticalAlignment
            ) {
                Item(
                    modifier = Modifier.background(color = Color.Green)
                )
                Item(
                    modifier = Modifier.background(color = Color.Yellow)
                )
                Item(
                    modifier = Modifier.background(color = Color.Red)
                )
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
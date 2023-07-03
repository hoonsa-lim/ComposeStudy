package com.hoonsalim.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hoonsalim.composestudy.animation.AnimationChapter
import com.hoonsalim.composestudy.animation.AnimationSpecChapter
import com.hoonsalim.composestudy.canvas.CanvasChapter
import com.hoonsalim.composestudy.row_column.RowColumnChapter
import com.hoonsalim.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {

    private val chapters = listOf<Chapter>(
        RowColumnChapter(),
        AnimationChapter(),
        AnimationSpecChapter(),
        CanvasChapter()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ){
                        composable("home"){
                            HomePage(
                                chapters = chapters,
                                navController = navController,
                            )
                        }
                        chapters.forEach { chapter ->
                            composable(chapter.destination){
                                chapter.Page()
                            }
                        }
                    }
                }
            }
        }
    }

}

@Composable
private fun HomePage(
    chapters: List<Chapter>,
    navController: NavHostController,
) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp)
    ){
        item {
            Text(
                text = "Home",
                style = MaterialTheme.typography.h4,
            )
        }
        items(
            items = chapters,
            key = { item -> item.titleStringResourceId },
        ){
            ChapterItem(
                modifier = Modifier.padding(bottom = 8.dp),
                onClick = {
                    navController.navigate(it.destination)
                },
                title = stringResource(id = it.titleStringResourceId),
            )
        }
    }
}

@Composable
private fun ChapterItem(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier.then(
            Modifier.fillMaxWidth()
                .height(60.dp)
                .clickable(onClick = onClick)
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        ChapterItem(
            title = "asdfasdfasdf",
            onClick = {}
        )
    }
}
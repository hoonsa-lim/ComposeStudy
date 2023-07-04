package com.hoonsalim.composestudy.viewmodel

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.hoonsalim.composestudy.Chapter
import com.hoonsalim.composestudy.R

class ViewModelChapter: Chapter {
    override val titleStringResourceId: Int = R.string.viewmodel
    override val destination: String = "view_model"

    @Composable
    override fun Page() {
        val context = LocalContext.current

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Button(onClick = {
                val intent = Intent(context, MvvmViewModelActivity::class.java)
                context.startActivity(intent)
            }) {
                Text(text = "open Mvvm ViewModel activity")
            }
            Button(onClick = {
                val intent = Intent(context, AndroidViewModelActivity::class.java)
                context.startActivity(intent)
            }) {
                Text(text = "open Android ViewModel activity")
            }
        }
    }
}
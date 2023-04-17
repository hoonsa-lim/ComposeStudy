package com.hoonsalim.composestudy

import androidx.compose.runtime.Composable

interface Chapter {
    val titleStringResourceId: Int
    val destination: String

    @Composable
    fun Page()
}
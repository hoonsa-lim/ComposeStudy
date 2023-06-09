package com.hoonsalim.composestudy.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.hoonsalim.composestudy.ui.theme.ComposeStudyTheme

class MvvmViewModelActivity : ComponentActivity() {
    private val viewModel = MvvmViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MvvmViewModelScreenSetup(viewModel)
                }
            }
        }
    }
}

@Composable
fun MvvmViewModelScreenSetup(
    viewModel: MvvmViewModel,
) {
    MemoListScreen(
        modifier = Modifier.fillMaxSize(),
        memos = viewModel.memos,
        onClickSave = { viewModel.save(it) }
    )
}

class AndroidViewModelActivity : ComponentActivity() {
    private val viewModel by viewModels<AndroidViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AndroidViewModelScreenSetup(viewModel)
                }
            }
        }
    }
}

@Composable
fun AndroidViewModelScreenSetup(
    viewModel: AndroidViewModel,
) {
    MemoListScreen(
        modifier = Modifier.fillMaxSize(),
        memos = viewModel.memos,
        onClickSave = { viewModel.save(it) }
    )
}

class LiveDataViewModelActivity : ComponentActivity() {
    private val viewModel by viewModels<LiveDataAndroidViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LiveDataViewModelScreenSetup(viewModel)
                }
            }
        }
    }
}

@Composable
fun LiveDataViewModelScreenSetup(
    viewModel: LiveDataAndroidViewModel,
) {
    //implementation "androidx.compose.runtime:runtime-livedata:1.3.2"
    val memos by viewModel.memos.observeAsState()

    MemoListScreen(
        modifier = Modifier.fillMaxSize(),
        memos = memos ?: "",
        onClickSave = { viewModel.save(it) }
    )
}

class MutableStateFlowViewModelActivity : ComponentActivity() {
    private val viewModel by viewModels<MutableStateFlowAndroidViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MutableStateFlowViewModelScreenSetup(viewModel)
                }
            }
        }
    }
}

@Composable
fun MutableStateFlowViewModelScreenSetup(
    viewModel: MutableStateFlowAndroidViewModel,
) {
    val memos by viewModel.memos.collectAsState()

    MemoListScreen(
        modifier = Modifier.fillMaxSize(),
        memos = memos,
        onClickSave = { viewModel.save(it) }
    )
}


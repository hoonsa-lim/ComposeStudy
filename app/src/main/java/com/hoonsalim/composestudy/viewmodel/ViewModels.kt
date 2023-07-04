package com.hoonsalim.composestudy.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MvvmViewModel {
    var memos by mutableStateOf("")

    fun save(text: String) {
        memos = memos.plus("\n\n$text")
    }
}

class AndroidViewModel: ViewModel() {
    var memos by mutableStateOf("")

    fun save(text: String) {
        memos = memos.plus("\n\n$text")
    }

    override fun onCleared() {
        super.onCleared()
        println("Android viewModel clear!!!")
    }
}

class LiveDataAndroidViewModel: ViewModel() {
    var memos = MutableLiveData<String>()

    fun save(text: String) {
        memos.postValue(memos.value + "\n\n$text")      //LiveData
    }

    override fun onCleared() {
        super.onCleared()
        println("LiveDataAndroidViewModel clear!!!")
    }
}

class MutableStateFlowAndroidViewModel: ViewModel() {
    var memos = MutableStateFlow("")

    fun save(text: String) {
        memos.update { it + "\n\n$text" }
    }

    override fun onCleared() {
        super.onCleared()
        println("MutableStateFlowAndroidViewModel clear!!!")
    }
}
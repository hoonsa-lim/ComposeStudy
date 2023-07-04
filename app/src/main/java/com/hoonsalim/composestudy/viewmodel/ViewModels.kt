package com.hoonsalim.composestudy.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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
        println("Android viewModel clear!!!")
    }
}

class MutableStateFlowAndroidViewModel: ViewModel() {
    var memos = MutableStateFlow<String>("")

    fun save(text: String) {
        memos.update { it + "\n\n$text" }
    }

    override fun onCleared() {
        super.onCleared()
        println("Android viewModel clear!!!")
    }
}
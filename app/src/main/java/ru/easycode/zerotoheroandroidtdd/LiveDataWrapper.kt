package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {
    fun update(value: UiState)
    fun liveData(): LiveData<UiState>
    class Base:LiveDataWrapper{
        private val actualCallsList = mutableListOf<UiState>()
        private val data:MutableLiveData<UiState> = MutableLiveData()

        override fun update(value: UiState) {
            actualCallsList.add(value)
        }

        override fun liveData(): LiveData<UiState> {
            data.value = actualCallsList.removeFirst()
            return data
        }
    }
}
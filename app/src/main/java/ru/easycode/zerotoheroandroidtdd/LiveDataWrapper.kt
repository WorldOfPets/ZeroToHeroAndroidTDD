package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {
    fun save(bundleWrapper: BundleWrapper.Save)
    fun update(value: UiState)
    fun liveData(): LiveData<UiState>
    class Base:LiveDataWrapper{
        private var liveData= MutableLiveData<UiState> ()
        override fun save(bundleWrapper: BundleWrapper.Save) {
           //bundleWrapper.save(liveData.value!!)
            liveData.value?.let { bundleWrapper.save(it) }
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }

    }
}
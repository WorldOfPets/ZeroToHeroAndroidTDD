package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle

interface BundleWrapper {
    interface Mutable:Save, Restore{
    }
    interface Save:BundleWrapper{
        fun save(uiState: UiState)
    }
    interface Restore:BundleWrapper{
        fun restore(): UiState
    }
    class Base(
        private val bundle:Bundle
    ):Mutable{
        private var _uiState = SingleLiveEvent<UiState>()
        override fun save(uiState: UiState) {
            bundle.putSerializable("uiSate", uiState)
        }

        override fun restore(): UiState {
            return bundle.getSerializable("uiState", UiState::class.java) as UiState
        }

    }
}
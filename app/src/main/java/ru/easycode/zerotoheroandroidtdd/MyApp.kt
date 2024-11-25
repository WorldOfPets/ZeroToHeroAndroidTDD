package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class MyApp : Application() {
    val viewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base())
}
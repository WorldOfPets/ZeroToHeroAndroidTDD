package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class MainViewModel(private val liveDataWrapper:LiveDataWrapper, private val repository: Repository) :ViewModel(){
    private var _uiState:MutableLiveData<UiState> = MutableLiveData()
    val uiState:LiveData<UiState> = _uiState

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    fun liveData() = liveDataWrapper.liveData()
    fun load(){
        liveDataWrapper.update(UiState.ShowProgress)
        CoroutineScope(Dispatchers.Main).launch {
            repository.load()
            liveDataWrapper.update(UiState.ShowData)
        }
    }
}
package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val liveDataWrapper:LiveDataWrapper.Mutable,
    private val repository: Repository
){
    fun load(){
        liveDataWrapper.update(UiState.ShowProgress)
        CoroutineScope(Dispatchers.Main).launch {
            val result = repository.load()
            result.show(liveDataWrapper)
            //liveDataWrapper.update(UiState.ShowData(result))
        }
    }
    fun save(bundleWrapper:BundleWrapper.Save){
        liveDataWrapper.save(bundleWrapper)
    }
    fun restore(bundleWrapper: BundleWrapper.Restore){
        //bundleWrapper.restore()
        liveDataWrapper.update(bundleWrapper.restore())
    }
    fun liveData() = liveDataWrapper.liveData()
}

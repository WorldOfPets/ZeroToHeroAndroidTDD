package ru.easycode.zerotoheroandroidtdd

import java.net.UnknownHostException

interface Repository {
    suspend fun load(): LoadResult

    class Base(val service:SimpleService, val url:String):Repository{
        private var actualCalledTimes: Int = 0

        override suspend fun load() : LoadResult{
            actualCalledTimes++
            try {
                val result = service.fetch(url)
                return LoadResult.Success(result)
            }catch (ex: UnknownHostException){
                return LoadResult.Error(noConnection = true)
            }catch (ex: IllegalStateException){
                return LoadResult.Error(noConnection = false)
            }

        }

    }
}
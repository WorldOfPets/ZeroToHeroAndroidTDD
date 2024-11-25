package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.delay

interface Repository {
    suspend fun load()

    class Base:Repository{
        private var actualCalledTimes: Int = 0
        override suspend fun load() {
            delay(3000)
            actualCalledTimes++
        }

    }
}
package ru.easycode.zerotoheroandroidtdd



interface Repository {
    suspend fun load(): SimpleResponse

    class Base(val service:SimpleService, val url:String):Repository{
        private var actualCalledTimes: Int = 0
        private val map = mutableMapOf<String, SimpleResponse>()

        init {
            map["a"] = SimpleResponse(text = "A")
            map["b"] = SimpleResponse(text = "B")
        }
        override suspend fun load() : SimpleResponse{
            actualCalledTimes++
            return if (url in map){
                map[url]!!
            }else{
                service.fetch(url)
            }
        }

    }
}
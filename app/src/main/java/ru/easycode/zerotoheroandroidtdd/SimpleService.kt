package ru.easycode.zerotoheroandroidtdd

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url


interface SimpleService {
    @GET
    suspend fun fetch(@Url url: String): SimpleResponse
    class Base:SimpleService{
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        private val service: SimpleService = retrofit.create(SimpleService::class.java)
        override suspend fun fetch(url: String): SimpleResponse {


            val actual =
                service.fetch(url = "https://raw.githubusercontent.com/JohnnySC/ZeroToHeroAndroidTDD/task/018-clouddatasource/app/sampleresponse.json")
            return actual
        }

    }
}
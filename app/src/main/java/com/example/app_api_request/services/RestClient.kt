package com.example.app_api_request.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {
    private val TAG = "Network"
    private val CONNECT_TIMEOUT = 20000
    private val WRITE_TIMEOUT = 20000
    private val READ_TIMEOUT = 20000
    private val baseUrl = "https://api.coindesk.com/v1/"

    private lateinit var apiService: ApiService

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)

        val interceptor =  HttpLoggingInterceptor()
        interceptor.level = (HttpLoggingInterceptor.Level.BODY)
        val client = okHttpClient.addInterceptor(interceptor).build()


        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        initServices(retrofit)
    }

    fun getService(): ApiService {
        return apiService
    }

    fun initServices (retrofit: Retrofit){
        apiService = retrofit.create(ApiService::class.java)
    }

}
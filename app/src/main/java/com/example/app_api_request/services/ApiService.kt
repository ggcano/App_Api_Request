package com.example.app_api_request.services

import com.example.app_api_request.dto.ApiDto
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("bpi/currentprice.json")
    fun getApi (): Call<ApiDto>

}
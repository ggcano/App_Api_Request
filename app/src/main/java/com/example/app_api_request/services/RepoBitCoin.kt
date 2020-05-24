package com.example.app_api_request.services

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.app_api_request.dto.ApiDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoBitCoin {
    private val restClient: RestClient = RestClient()


    fun getBitCoinFromApi(): MutableLiveData<ApiDto> {
        val mutableBitCoinData: MutableLiveData<ApiDto> = MutableLiveData()
        val call = restClient.getService().getApi()

        call.enqueue(object : Callback<ApiDto> {
            override fun onFailure(call: Call<ApiDto>, t: Throwable) {

                t.printStackTrace()
            }

            override fun onResponse(call: Call<ApiDto>, response: Response<ApiDto>) {
                mutableBitCoinData.value = response.body()
                Log.v(TAG, response.body().toString())
                val jsonData: String = response.body().toString()
            }

        })

        return mutableBitCoinData
    }

}
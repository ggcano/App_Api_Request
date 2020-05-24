package com.example.app_api_request.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app_api_request.dto.ApiDto
import com.example.app_api_request.services.RepoBitCoin

class MainViewModel: ViewModel () {

    private val repo = RepoBitCoin()
    private val mLiveData = MutableLiveData<ApiDto>()

    fun coinData(): MutableLiveData<ApiDto> {

        repo.getBitCoinFromApi().observeForever {
            mLiveData.value = it

        }
        return mLiveData
    }

}
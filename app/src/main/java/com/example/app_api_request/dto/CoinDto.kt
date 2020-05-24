package com.example.app_api_request.dto

import com.google.gson.annotations.SerializedName

data class CoinDto(

    @SerializedName("code")
    val codeDTO: String,

    @SerializedName("symbol")
    val symbolDTO: String,

    @SerializedName("rate")
    val rateDTO: String,

    @SerializedName("description")
    val descriptionDTO: String,

    @SerializedName("rate_float")
    val rateFloatDTO: Float

)
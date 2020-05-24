package com.example.app_api_request.dto

import com.google.gson.annotations.SerializedName

data class TimeDto(

    @SerializedName("updated")
    val update: String,

    @SerializedName("updateduk")
    val updatedUk: String,

    @SerializedName("updatedISO")
    val updatedISO: String

)
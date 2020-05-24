package com.example.app_api_request.dto

import com.google.gson.annotations.SerializedName

data class ApiDto (

    @SerializedName("time")
    val time: TimeDto,

    @SerializedName("disclaimer")
    val disclaimer: String,

    @SerializedName("chartName")
    val chartName: String,

    @SerializedName("bpi")
    val coinBpi: BpiDto
)
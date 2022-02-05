package com.example.webview.data.netwok.model

import com.google.gson.annotations.SerializedName

data class ExampleJson2(
    @SerializedName("args") val args: ArgsDto? = ArgsDto(),
    @SerializedName("headers") val headers: HeadersDto? = HeadersDto(),
    @SerializedName("origin") val origin: String?  = null,
    @SerializedName("url") val url: String?  = null
)

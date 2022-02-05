package com.example.webview.data.netwok.model

import com.google.gson.annotations.SerializedName

data class HeadersDto(
    @SerializedName("Accept") val accept: String? = null,
    @SerializedName("Accept-Encoding") val acceptEncoding: String? = null,
    @SerializedName("Accept-Language") val acceptLanguage: String? = null,
    @SerializedName("Connection") val connection: String? = null,
    @SerializedName("Host") val host: String? = null,
    @SerializedName("Sec-Ch-Ua") val secChUa: String? = null,
    @SerializedName("Sec-Ch-Ua-Mobile") val secChUaMobile: String? = null,
    @SerializedName("Sec-Ch-Ua-Platform") val secChUaPlatform: String? = null,
    @SerializedName("Sec-Fetch-Dest") val secFetchDest: String? = null,
    @SerializedName("Sec-Fetch-Mode") val secFetchMode: String? = null,
    @SerializedName("Sec-Fetch-Site") val secFetchSite: String? = null,
    @SerializedName("Sec-Fetch-User") val secFetchUser: String? = null,
    @SerializedName("Upgrade-Insecure-Requests") val upgradeInsecureRequests: String? = null,
    @SerializedName("User-Agent") val userAgent: String? = null,
    @SerializedName("Via") val via: String? = null,
    @SerializedName("X-Cloud-Trace-Context") val xCloudTraceContext: String? = null
)

package com.example.webview.data.netwok.api

import com.example.webview.data.netwok.model.ExampleJson2
import io.reactivex.Single
import retrofit2.http.GET



interface ApiService {

    @GET(KEY)
    fun getLinkHaveKey(): Single<ExampleJson2>

    @GET(EMPTY_KEY)
    fun getEmptyLink(): Single<ExampleJson2>

    companion object{
        const val EMPTY_KEY = "get"
        const val KEY = "get?key=showGame"
    }
}
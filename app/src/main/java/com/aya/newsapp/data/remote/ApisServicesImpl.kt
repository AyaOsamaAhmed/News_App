package com.aya.newsapp.data.remote

import com.aya.newsapp.domain.response.MainResponse
import com.aya.newsapp.utils.Constant.API_KEY
import io.ktor.client.request.*

object ApisServicesImpl : Apis {

    private val httpClient by lazy {
        KtorClient.getInstance
    }

    override suspend fun allNews(keyword: String): MainResponse {
        return httpClient.get( path= "/v2/everything") {
            parameter("q", keyword)
            parameter("apiKey", API_KEY)
        }
    }

}
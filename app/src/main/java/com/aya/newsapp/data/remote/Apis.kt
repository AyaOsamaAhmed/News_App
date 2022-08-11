package com.aya.newsapp.data.remote

import com.aya.newsapp.domain.response.MainResponse

interface Apis {

    suspend fun allNews( keyword:String):MainResponse?

}
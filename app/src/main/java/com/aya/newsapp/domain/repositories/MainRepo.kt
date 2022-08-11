package com.aya.newsapp.domain.repositories

import io.ktor.client.features.*
import android.util.Log
import com.aya.newsapp.data.remote.ApisServicesImpl
import com.aya.newsapp.domain.response.MainResponse

object MainRepo {

    suspend fun allNews(keyword: String): MainResponse?  {
        return   try {

           ApisServicesImpl.allNews(keyword)

        } catch (e:  ClientRequestException) {
            Log.d("MainRepo", "Response exception ${e.message}")
            null
        }

    }


}
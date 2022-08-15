package com.aya.newsapp.data.local

import androidx.annotation.WorkerThread
import com.aya.newsapp.domain.model.ArticlesTable

class NewsDataBaseRepository(val newsDao : NewsDataBaseDao) {


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAllNews(){
       // newsDao.getAllNews()
    }


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(news: ArticlesTable){
        newsDao.insertNews(news)
    }


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(news: ArticlesTable){
        newsDao.deleteNews(news)
    }
}
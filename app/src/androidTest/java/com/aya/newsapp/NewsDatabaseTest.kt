package com.aya.newsapp

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.aya.newsapp.domain.model.ArticlesTable
import com.aya.newsapp.data.local.NewsDataBase
import com.aya.newsapp.data.local.NewsDataBaseDao
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class NewsDatabaseTest {

    private lateinit var newsDataBaseDao : NewsDataBaseDao
    private lateinit var db: NewsDataBase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, NewsDataBase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        newsDataBaseDao = db.newsDataBaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    suspend fun insertAndGetNews() {
        val news = ArticlesTable(0,"author","title","desc",null,null,"2022-01-01",null,1)
        newsDataBaseDao.insertNews(news)
        val tonews = newsDataBaseDao.getAllNews()
        assertEquals(tonews, 1)
    }

}
package com.aya.newsapp.data.local

import androidx.room.*
import com.aya.newsapp.domain.model.ArticlesTable

@Dao
interface NewsDataBaseDao  {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun insertNews(news: ArticlesTable)

    @Delete
     suspend fun deleteNews(news: ArticlesTable)

    @Query("SELECT * from book_marks_table WHERE bookMark = 1 ")
    suspend fun getAllNews(): List<ArticlesTable>?

}
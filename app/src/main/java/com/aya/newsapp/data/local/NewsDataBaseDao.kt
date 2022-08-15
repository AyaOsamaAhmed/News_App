package com.aya.newsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.aya.newsapp.domain.model.ArticlesTable

@Dao
interface NewsDataBaseDao  {

    @Insert
      fun insertNews(news: ArticlesTable)

    @Update
      fun updateNews(news: ArticlesTable)

//    @Query("SELECT * from book_marks_table WHERE bookMark = 1 ")
//    suspend fun getAllNews(): ArrayList<ArticlesTable>?

}
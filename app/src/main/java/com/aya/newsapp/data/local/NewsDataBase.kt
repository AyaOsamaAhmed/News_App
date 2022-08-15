package com.aya.newsapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aya.newsapp.domain.model.ArticlesTable

@Database(entities = [ArticlesTable::class], version = 1,  exportSchema = false)
abstract class NewsDataBase : RoomDatabase() {

    abstract val newsDataBaseDao : NewsDataBaseDao

    companion object {

        @Volatile
        private var INSTANCE: NewsDataBase? = null

        fun getInstance(context: Context): NewsDataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NewsDataBase::class.java,
                        "news_bookMarks_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

}
}
package com.aya.newsapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "book_marks_table")
data class ArticlesTable (
    @PrimaryKey(autoGenerate = true)
    var newsId : Int = 0 ,

    @ColumnInfo(name = "author")
    var author : String?,

    @ColumnInfo(name = "title")
    val title :String?,

    @ColumnInfo(name = "description")
    val description : String?,

    @ColumnInfo(name = "url")
    val url : String?,

    @ColumnInfo(name = "urlToImage")
    val urlToImage : String?,

    @ColumnInfo(name = "publishedAt")
    var publishedAt:String?,

    @ColumnInfo(name = "content")
    val content : String?,

    @ColumnInfo(name = "bookMark")
    val bookMark : Int?
)
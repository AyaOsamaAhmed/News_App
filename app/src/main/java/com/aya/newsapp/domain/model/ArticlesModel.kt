package com.aya.newsapp.domain.model

data class ArticlesModel (
    val source : SourceModel,
    var author : String ,
    val title :String ,
    val description : String,
    val url : String ,
    val urlToImage : String,
    val publishedAt:String ,
    val content : String
)
package com.aya.newsapp.presentation.interfaces

import com.aya.newsapp.domain.model.ArticlesTable

interface onClickDetails {

    fun onClick(artical : ArticlesTable)

    fun onClickBookMarks(artical : ArticlesTable)


}
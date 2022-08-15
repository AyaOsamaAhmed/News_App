package com.aya.newsapp.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aya.newsapp.domain.model.ArticlesTable
import com.aya.newsapp.data.local.NewsDataBase
import com.aya.newsapp.domain.repositories.MainRepo
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var requestBannerLiveData = MutableLiveData<Any>()

    var requestLastNewsLiveData = MutableLiveData<Any>()

    var requestBookMarksLiveData = MutableLiveData<Any>()

    init {
        BannerNews("egypt")
        LastestNews("bbc-news, the-next-web")
    }

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    fun BannerNews(keyword: String){
        viewModelScope.launch(Dispatchers.IO ) {
            requestBannerLiveData.postValue(MainRepo.allNews(keyword))
        }
    }

    fun LastestNews(keyword: String){
        viewModelScope.launch(Dispatchers.IO ) {
            requestLastNewsLiveData.postValue(MainRepo.allNews(keyword))
        }
    }

    fun setBookMark(instance: NewsDataBase , news: ArticlesTable){
        viewModelScope.launch(Dispatchers.IO ) {
            requestBookMarksLiveData.postValue( instance.newsDataBaseDao.insertNews(news))
        }
    }


}
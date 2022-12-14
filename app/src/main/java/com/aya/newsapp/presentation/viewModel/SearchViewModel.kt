package com.aya.newsapp.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aya.newsapp.domain.repositories.MainRepo
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    var requestSearchLiveData = MutableLiveData<Any>()

    init {
        AllNews("keyword")
    }

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    fun AllNews(keyword: String){
        viewModelScope.launch(Dispatchers.IO ) {
            requestSearchLiveData.postValue(MainRepo.allNews(keyword))
        }
    }


}
package com.aya.newsapp.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aya.newsapp.domain.repositories.MainRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var requestBannerLiveData = MutableLiveData<Any>()

    init {
        AllNews("keyword")
    }


    fun AllNews(keyword: String){
        viewModelScope.launch(Dispatchers.IO) {
            requestBannerLiveData.postValue(MainRepo.allNews(keyword))
        }
    }


}
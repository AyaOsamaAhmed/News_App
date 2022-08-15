package com.aya.newsapp.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aya.newsapp.data.local.NewsDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookMarksViewModel : ViewModel() {

    var requestBookMarksiveData = MutableLiveData<Any>()

    fun getAllBookMark(instance: NewsDataBase){
        viewModelScope.launch(Dispatchers.IO ) {
           // requestBookMarksiveData.value =  instance.newsDataBaseDao.get()
        }
    }


}
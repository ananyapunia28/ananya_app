package com.hackygirls.kavachh.couroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (private val repository: Repository): ViewModel(){
    var myResponse: MutableLiveData<Response<Post>> = MutableLiveData()

    fun pushPost(post: Post) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }
}
package com.hackygirls.kavachh.Login

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackygirls.kavachh.dataClass.Login
import com.hackygirls.kavachh.dataClass.Resource
import com.hackygirls.kavachh.dataClass.Trnsactns
import com.hackygirls.kavachh.transactions.TrnsacRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val login: LoginRepo): ViewModel() {
    var myResponse: MutableLiveData<Resource<Response<Login>>> = MutableLiveData()
    public fun pushPost(resp : Login){
        viewModelScope.launch {

            myResponse.postValue(Resource.loading(null))
//            val response = repository.pushPost(resp, "Basic")
//            myResponse.value = response
            try {

                val userFromApi = login.pushPost(resp, "Basic")
                myResponse.postValue(Resource.success(userFromApi))
            } catch (e: Exception) {
                myResponse.postValue(Resource.error(e.toString(), null))
            }
//            Log.d("Main", response.body().toString())
        }
    }
    fun postUser() : MutableLiveData<Resource<Response<Login>>> = myResponse
}
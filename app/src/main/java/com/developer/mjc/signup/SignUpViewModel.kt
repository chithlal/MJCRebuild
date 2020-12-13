package com.developer.mjc.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.developer.mjc.model.User


class SignUpViewModel(): ViewModel() {

     val signLiveData = MutableLiveData<User>()


    fun signUp(signupData: User){
        if(suucess){
            signLiveData.postValue("")
        }
    }
}
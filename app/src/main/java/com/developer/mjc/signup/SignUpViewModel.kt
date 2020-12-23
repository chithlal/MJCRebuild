package com.developer.mjc.signup

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.developer.mjc.firebase.FirestoreClass
import com.developer.mjc.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase


class SignUpViewModel(): ViewModel(),FirestoreClass.FirebaseListener {

     val signLiveData = MutableLiveData<User>()
     val signupErrorLiveData = MutableLiveData<String>()


    fun signUp(signupData: User, pwd:String,context:Context){
// Need to replace "Abcd@1234" with the password from user
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(signupData.email,pwd).addOnCompleteListener {
            task ->
            if(task.isSuccessful){
                val firebaseUser : FirebaseUser = task.result!!.user!!
                val user = User(firebaseUser.uid,signupData.name,signupData.email,signupData.phone)
                FirestoreClass().registerUser(user, object : FirestoreClass.FirebaseListener{
                    override fun onSuccess(userInfo: User) {
                        signLiveData.postValue(userInfo)
                    }

                    override fun onFailture(messageString: String) {
                        signupErrorLiveData.postValue(messageString)
                    }

                })


            }
        }

    }

    override fun onSuccess(userInfo: User) {
        TODO("Not yet implemented")
    }

    override fun onFailture(messageString: String) {
        TODO("Not yet implemented")
    }
}
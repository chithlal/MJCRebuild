package com.developer.mjc.firebase

import android.widget.Toast
import com.developer.mjc.model.User
import com.developer.mjc.signup.SignupActivity
import com.developer.mjc.util.MjcConstants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.ktx.Firebase

class FirestoreClass {

    private val mFirestore = FirebaseFirestore.getInstance()
    fun registerUser( userInfo:User, firebaseListener: FirebaseListener){
        mFirestore.collection(MjcConstants.USERS).document(getCurrentUserID()).set(userInfo,
            SetOptions.merge()).addOnSuccessListener {

                // Method when successfully completed
               firebaseListener.onSuccess(userInfo)
                FirebaseAuth.getInstance().signOut()
        }
    }

    //Function to get current user id
    fun getCurrentUserID():String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }

    interface FirebaseListener{
        fun onSuccess(userInfo: User)
        fun onFailture(messageString: String)
    }
}
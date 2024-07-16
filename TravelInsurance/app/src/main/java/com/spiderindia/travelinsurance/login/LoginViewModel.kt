package com.spiderindia.travelinsurance.login

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spiderindia.travelinsurance.R
import com.spiderindia.travelinsurance.mbo.User

class LoginViewModel : ViewModel() {

    val TAG = LoginViewModel::class.java.name
    private val _liveUser = MutableLiveData<User>(User("",""))
    val liveUser: LiveData<User> = _liveUser
    private val _errorUser: MutableLiveData<Int> = MutableLiveData(R.string.empty)
    val errorUser : LiveData<Int> = _errorUser
    private val _errorPassword: MutableLiveData<Int> = MutableLiveData(R.string.empty)
    val errorPassword : LiveData<Int> = _errorPassword
    val isFingerPrintEnabled = ObservableField<Boolean>(true)


    fun onClickLogin(): Boolean
    {

        Log.d(TAG, "is clicked : ${isFingerPrintEnabled.get()} "  )
        var isValid = true

        if (liveUser.value?.username.isNullOrEmpty())
        {
            _errorUser.postValue(R.string.please_username)
            isValid =  false
        }
        else
        {
            _errorUser.postValue(R.string.empty)
        }

        if (liveUser.value?.password.isNullOrEmpty())
        {
            _errorPassword.postValue(R.string.please_password)
            isValid =  false
        }
        else
        {
            _errorPassword.postValue(R.string.empty)
        }

        return isValid

    }


}
package com.spiderindia.travelinsurance.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spiderindia.travelinsurance.mbo.User
import com.spiderindia.travelinsurance.mbo.UserError

class RegistrationViewModel : ViewModel() {

    private val _liveUserData = MutableLiveData<User>(User())
    val liveUserData: LiveData<User> = _liveUserData
    private val _liveUserError = MutableLiveData<UserError>(UserError())
    val liveUserError : LiveData<UserError> = _liveUserError


}
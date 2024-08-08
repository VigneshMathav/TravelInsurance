package com.spiderindia.travelinsurance.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spiderindia.travelinsurance.R
import com.spiderindia.travelinsurance.model.mbo.User
import com.spiderindia.travelinsurance.model.mbo.UserError

class RegistrationViewModel : ViewModel() {

    private val _liveUserData = MutableLiveData<User>(User())
    val liveUserData: LiveData<User> = _liveUserData
    private val _liveUserError = MutableLiveData<UserError>(UserError())
    val liveUserError: LiveData<UserError> = _liveUserError

    fun isValidInput(confirmPassword: String): Boolean {
        var isValid = true

        if (liveUserData.value?.firstName.isNullOrEmpty())
        {
            _liveUserError.postValue(UserError(firstname = R.string.enter_first_name))
            isValid = false
        }
        if (isValid && liveUserData.value?.lastName.isNullOrEmpty()) {
            _liveUserError.postValue(UserError(lastname = R.string.enter_last_name))
            isValid = false
        }
        if (isValid && liveUserData.value?.mobile.isNullOrEmpty()) {
            _liveUserError.postValue(UserError(mobile = R.string.enter_mobile))
            isValid = false
        }
        val PHONE_NUMBER_PATTERN = "^\\d{10}\$".toRegex()
        if (isValid && !PHONE_NUMBER_PATTERN.matches(liveUserData.value?.mobile!!)) {
            _liveUserError.postValue(UserError(mobile =  R.string.msg_error_valid_mobileNumber))
            isValid = false
        }
        if (isValid && liveUserData.value?.email.isNullOrEmpty()) {
            _liveUserError.postValue(UserError(email = R.string.enter_email_address))
            isValid = false
        }
        if (isValid && liveUserData.value?.username.isNullOrEmpty()) {
            _liveUserError.postValue(UserError(username = R.string.enter_user_name))
            isValid = false
        }
        if (isValid && liveUserData.value?.password.isNullOrEmpty()) {
            _liveUserError.postValue(UserError(password = R.string.enter_password))
            isValid = false
        }
        if (isValid && liveUserData.value?.confirmpassword.isNullOrEmpty()) {
            _liveUserError.postValue(UserError(confirmpassword = R.string.enter_confirm_password))
            isValid = false
        }
        if (isValid && confirmPassword != liveUserData.value?.password) {
            _liveUserError.postValue(UserError(confirmpassword =  R.string.msg_error_passwordnotmatch))
            isValid = false
        }


        return isValid


    }


}
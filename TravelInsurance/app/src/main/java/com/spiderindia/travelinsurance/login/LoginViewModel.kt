package com.spiderindia.travelinsurance.login

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spiderindia.travelinsurance.R
import com.spiderindia.travelinsurance.model.mbo.User
import com.spiderindia.travelinsurance.model.repository.TravelRepository
import com.spiderindia.travelinsurance.util.Resource
import com.spiderindia.travelinsurance.util.toSHA256Hash
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LoginViewModel(private val repository : TravelRepository) : ViewModel() {

    val TAG = LoginViewModel::class.java.name
    private val _liveUser = MutableLiveData<User>(User())
    val liveUser: LiveData<User> = _liveUser
    private val _errorUser: MutableLiveData<Int> = MutableLiveData(R.string.empty)
    val errorUser : LiveData<Int> = _errorUser
    private val _errorPassword: MutableLiveData<Int> = MutableLiveData(R.string.empty)
    val errorPassword : LiveData<Int> = _errorPassword
    val isFingerPrintEnabled = ObservableField<Boolean>(true)

    var liveLoginFlow = MutableLiveData<Resource.Status>(Resource.Status.NONE)


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

        if (isValid)
        {
            viewModelScope.launch(IO) {
                liveLoginFlow.postValue(Resource.Status.LOADING)
                val user = repository.findByUserNamePassword(liveUser.value!!.username,
                    liveUser.value!!.password.toSHA256Hash())
                if (user?.uid == null)
                {
                    _errorPassword.postValue(R.string.invalid_user_password)
                    liveLoginFlow.postValue(Resource.Status.ERROR)
                }
                else
                {
                    liveLoginFlow.postValue(Resource.Status.SUCCESS)
                }
            }
        }
        return isValid

    }


}
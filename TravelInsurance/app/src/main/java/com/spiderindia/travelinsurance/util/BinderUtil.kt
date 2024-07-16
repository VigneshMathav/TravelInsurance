package com.spiderindia.travelinsurance.util

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("errorText")
fun setErrorMessage(view: TextInputLayout, errorMessage: LiveData<Int>?) {
    errorMessage?.observeForever { errorResId ->
        if (errorResId != null && errorResId != 0) {
            view.error = view.context.getString(errorResId)
        } else {
            view.error = null
        }
    }
}
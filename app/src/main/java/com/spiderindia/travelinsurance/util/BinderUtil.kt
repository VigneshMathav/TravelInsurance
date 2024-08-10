package com.spiderindia.travelinsurance.util

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputLayout
import com.spiderindia.travelinsurance.R
import java.security.MessageDigest

object BinderUtil {
    @JvmStatic
    @BindingAdapter("app:errorText")
    fun setError(textInputLayout: TextInputLayout, error:Int) {
        if (error== R.string.empty) {
            textInputLayout.error = null
        } else {
            textInputLayout.error = textInputLayout.context.getString(error)
            textInputLayout.requestFocus()
        }
    }
    val PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$".toRegex()
}

fun String.toSHA256Hash(): String {
    val bytes = this.toString().toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}
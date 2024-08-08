package com.spiderindia.travelinsurance.util

import android.net.http.UrlRequest.Status

data class Resource<out T>(val status: Status,val data: T?,val message: String?)
{

    fun<T> success(data: T): Resource<T> = Resource(
        status = Status.SUCCESS, data = data, message = null
    )
    fun<T> Error(data: T?): Resource<T> = Resource(
        status = Status.ERROR,data = data, message = message
    )
    fun<T> loading(data: T?): Resource<T> = Resource(
        status = Status.LOADING,data = data, message = null
    )
    fun<T> idle(data: T?): Resource<T> = Resource(
        status = Status.NONE, data = data, message = null
    )



    enum class Status
    {
        NONE,
        SUCCESS,
        ERROR,
        LOADING
    }

}
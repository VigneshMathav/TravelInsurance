package com.spiderindia.travelinsurance.common

import android.app.Application
import com.spiderindia.travelinsurance.model.mbo.User


class TIApplication:Application() {
    companion object {
        var currUser: User? = null
    }
}
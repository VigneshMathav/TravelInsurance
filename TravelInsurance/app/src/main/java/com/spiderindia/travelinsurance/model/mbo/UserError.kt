package com.spiderindia.travelinsurance.model.mbo

import com.spiderindia.travelinsurance.R

data class UserError(var firstname : Int = R.string.empty,
                     var lastname : Int = R.string.empty,
                     var mobile : Int = R.string.empty,
                     var email : Int = R.string.empty,
                     var username : Int = R.string.empty,
                     var password : Int = R.string.empty,
                     var confirmpassword : Int = R.string.empty) {
}
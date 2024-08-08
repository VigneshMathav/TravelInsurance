package com.spiderindia.travelinsurance.model.mbo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@PrimaryKey val uid : Int ?= null,var firstName : String= "",var lastName : String="",
                var email : String="", var mobile : String="",
                var username:String="", var password:String="",
                var confirmpassword :String="") {



}
package com.spiderindia.travelinsurance.model.mbo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vehicle(@PrimaryKey val uid : Int? = null, var vNumber : String="", var vYear : String="",
                    var vMake : String="", var vModel : String="",var vEngineNumber : String="", var vZipcode : String ="", var vOwnerNUmber : String="",
                    var vUsage : String="" , var vAnnualMillage : String="") {
}
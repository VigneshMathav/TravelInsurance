package com.spiderindia.travelinsurance.slider

import android.os.Parcel
import android.os.Parcelable

class IntroInfo : Parcelable {

    var title: String?
    var description: String?
    var image: Int

    constructor(title: String?, description: String?, image: Int){
        this.title = title
        this.description = description
        this.image = image
    }


    init {
        title = null
        description = null
        image = 0
    }

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader)as Int
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IntroInfo> {
        override fun createFromParcel(parcel: Parcel): IntroInfo {
            return IntroInfo(parcel)
        }

        override fun newArray(size: Int): Array<IntroInfo?> {
            return arrayOfNulls(size)
        }
    }


}
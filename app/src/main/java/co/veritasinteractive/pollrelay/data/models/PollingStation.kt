package co.veritasinteractive.pollrelay.data.models

import android.os.Parcel
import android.os.Parcelable

data class PollingStation(var name: String?): Parcelable{
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PollingStation> {
        override fun createFromParcel(parcel: Parcel): PollingStation {
            return PollingStation(parcel)
        }

        override fun newArray(size: Int): Array<PollingStation?> {
            return arrayOfNulls(size)
        }
    }

}
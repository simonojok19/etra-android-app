package co.veritasinteractive.pollrelay.data.models

import android.os.Parcel
import android.os.Parcelable

data class County(var name: String?, var subcounties: Array<SubCounty>?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createTypedArray(SubCounty)
    ) {
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as County

        if (name != other.name) return false
        if (subcounties != null) {
            if (other.subcounties == null) return false
            if (!subcounties!!.contentEquals(other.subcounties!!)) return false
        } else if (other.subcounties != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (subcounties?.contentHashCode() ?: 0)
        return result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeTypedArray(subcounties, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<County> {
        override fun createFromParcel(parcel: Parcel): County {
            return County(parcel)
        }

        override fun newArray(size: Int): Array<County?> {
            return arrayOfNulls(size)
        }
    }

}
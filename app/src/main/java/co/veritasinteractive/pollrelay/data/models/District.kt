package co.veritasinteractive.pollrelay.data.models

import android.os.Parcel
import android.os.Parcelable

data class District(var name: String?, var counties: Array<County>?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createTypedArray(County)
    ) {
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as District

        if (name != other.name) return false
        if (counties != null) {
            if (other.counties == null) return false
            if (!counties!!.contentEquals(other.counties!!)) return false
        } else if (other.counties != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (counties?.contentHashCode() ?: 0)
        return result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeTypedArray(counties, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<District> {
        override fun createFromParcel(parcel: Parcel): District {
            return District(parcel)
        }

        override fun newArray(size: Int): Array<District?> {
            return arrayOfNulls(size)
        }
    }
}
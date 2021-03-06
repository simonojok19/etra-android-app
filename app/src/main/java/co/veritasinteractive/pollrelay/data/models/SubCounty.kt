package co.veritasinteractive.pollrelay.data.models

import android.os.Parcel
import android.os.Parcelable

data class SubCounty(var name: String?, var parishs: Array<Parish>?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createTypedArray(Parish)
    ) {
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SubCounty

        if (name != other.name) return false
        if (parishs != null) {
            if (other.parishs == null) return false
            if (!parishs!!.contentEquals(other.parishs!!)) return false
        } else if (other.parishs != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (parishs?.contentHashCode() ?: 0)
        return result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeTypedArray(parishs, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SubCounty> {
        override fun createFromParcel(parcel: Parcel): SubCounty {
            return SubCounty(parcel)
        }

        override fun newArray(size: Int): Array<SubCounty?> {
            return arrayOfNulls(size)
        }
    }

}
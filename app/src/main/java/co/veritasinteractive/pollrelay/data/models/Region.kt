package co.veritasinteractive.pollrelay.data.models

import android.os.Parcel
import android.os.Parcelable

data class Region(var name: String?, var districts: Array<District>?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createTypedArray(District)
    ) {
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Region

        if (name != other.name) return false
        if (districts != null) {
            if (other.districts == null) return false
            if (!districts!!.contentEquals(other.districts!!)) return false
        } else if (other.districts != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (districts?.contentHashCode() ?: 0)
        return result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeTypedArray(districts, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Region> {
        override fun createFromParcel(parcel: Parcel): Region {
            return Region(parcel)
        }

        override fun newArray(size: Int): Array<Region?> {
            return arrayOfNulls(size)
        }
    }
}
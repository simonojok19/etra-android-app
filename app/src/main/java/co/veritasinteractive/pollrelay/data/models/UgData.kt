package co.veritasinteractive.pollrelay.data.models

import android.os.Parcel
import android.os.Parcelable

data class UgData(var regions: Array<Region>?): Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArray(Region)) {
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UgData

        if (regions != null) {
            if (other.regions == null) return false
            if (!regions!!.contentEquals(other.regions!!)) return false
        } else if (other.regions != null) return false

        return true
    }

    override fun hashCode(): Int {
        return regions?.contentHashCode() ?: 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedArray(regions, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UgData> {
        override fun createFromParcel(parcel: Parcel): UgData {
            return UgData(parcel)
        }

        override fun newArray(size: Int): Array<UgData?> {
            return arrayOfNulls(size)
        }
    }
}
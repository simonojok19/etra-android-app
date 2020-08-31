package co.veritasinteractive.pollrelay.data.models

import android.os.Parcel
import android.os.Parcelable

data class Parish(var name: String?, var pollingstations: Array<PollingStation>?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createTypedArray(PollingStation)
    ) {
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Parish

        if (name != other.name) return false
        if (pollingstations != null) {
            if (other.pollingstations == null) return false
            if (!pollingstations!!.contentEquals(other.pollingstations!!)) return false
        } else if (other.pollingstations != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (pollingstations?.contentHashCode() ?: 0)
        return result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeTypedArray(pollingstations, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Parish> {
        override fun createFromParcel(parcel: Parcel): Parish {
            return Parish(parcel)
        }

        override fun newArray(size: Int): Array<Parish?> {
            return arrayOfNulls(size)
        }
    }

}
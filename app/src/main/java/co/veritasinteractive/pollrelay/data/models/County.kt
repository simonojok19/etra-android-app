package co.veritasinteractive.pollrelay.data.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "county")
data class County(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    var name: String?,
    @Ignore
    var subcounties: Array<SubCounty>?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.createTypedArray(SubCounty)
    ) {
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as County

        if (id != other.id) return false
        if (name != other.name) return false
        if (subcounties != null) {
            if (other.subcounties == null) return false
            if (!subcounties!!.contentEquals(other.subcounties!!)) return false
        } else if (other.subcounties != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (subcounties?.contentHashCode() ?: 0)
        return result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
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
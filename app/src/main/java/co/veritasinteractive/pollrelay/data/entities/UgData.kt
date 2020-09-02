package co.veritasinteractive.pollrelay.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "uganda_data")
data class UgData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var data: String
) {
}
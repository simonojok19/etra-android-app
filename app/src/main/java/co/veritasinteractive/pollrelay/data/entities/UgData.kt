package co.veritasinteractive.pollrelay.data.entities

import androidx.room.Entity

@Entity(tableName = "uganda_data")
data class UgData(
    var id: Int,
    var data: String
) {
}
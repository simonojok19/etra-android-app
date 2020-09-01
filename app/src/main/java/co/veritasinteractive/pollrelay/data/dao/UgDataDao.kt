package co.veritasinteractive.pollrelay.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import co.veritasinteractive.pollrelay.data.entities.UgData

@Dao
interface UgDataDao {
    @Insert
    fun insertUgData(ugDataDao: UgData)

    @Delete
    fun deleteUgData(ugDataDao: UgData)

    @Query("SELECT * FROM uganda_data")
    fun getUgDataNormalData(): List<UgData>

    @Query("SELECT * FROM uganda_data")
    fun getUgDataLiveData(): LiveData<List<UgData>>
}
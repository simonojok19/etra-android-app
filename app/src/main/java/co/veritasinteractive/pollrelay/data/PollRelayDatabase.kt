package co.veritasinteractive.pollrelay.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import co.veritasinteractive.pollrelay.data.dao.UgDataDao
import co.veritasinteractive.pollrelay.data.entities.UgData

@Database(entities = [UgData::class], version = 1, exportSchema = false)
abstract class PollRelayDatabase: RoomDatabase {
    abstract fun ugDataDao(): UgDataDao

    companion object {
        @Volatile
        private var INSTANCE: PollRelayDatabase? = null

        fun getDatabase(context: Context): PollRelayDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null ) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PollRelayDatabase::class.java,
                    "poll_relay_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}
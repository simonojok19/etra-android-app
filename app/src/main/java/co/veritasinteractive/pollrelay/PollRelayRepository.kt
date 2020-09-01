package co.veritasinteractive.pollrelay

import android.content.Context
import androidx.room.Room
import co.veritasinteractive.pollrelay.data.PollRelayDatabase

class PollRelayRepository(context: Context) {
    private var database: PollRelayDatabase? = null;

    companion object {
        @Volatile
        private var INSTANCE: PollRelayRepository? = null

        fun getDatabase(context: Context): PollRelayRepository {
            val tempInstance = INSTANCE
            if (tempInstance != null ) {
                return tempInstance
            }

            synchronized(this) {
                val instance = PollRelayRepository(context)
                INSTANCE = instance
                return instance
            }

        }
    }

    init {
        database = PollRelayDatabase.getDatabase(context)
    }
}
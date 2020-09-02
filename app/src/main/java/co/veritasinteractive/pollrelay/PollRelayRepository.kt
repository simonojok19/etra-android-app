package co.veritasinteractive.pollrelay

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import androidx.room.Room
import co.veritasinteractive.pollrelay.data.PollRelayDatabase
import co.veritasinteractive.pollrelay.data.models.Region
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class PollRelayRepository(context: Context) {
    private var database: PollRelayDatabase? = null;
    lateinit var region: Region;

    companion object {
        @Volatile
        private var INSTANCE: PollRelayRepository? = null

        fun getInstance(context: Context): PollRelayRepository {
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
        val assetManager: AssetManager = context.applicationContext.assets
        val inputStream = assetManager.open("ug_data/ugdata.json")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val data: co.veritasinteractive.pollrelay.data.models.Region = Gson().fromJson(bufferedReader, co.veritasinteractive.pollrelay.data.models.Region::class.java)
        data.let {
            region = it
        }
        Log.d("MainActivity", region.toString())
    }
}
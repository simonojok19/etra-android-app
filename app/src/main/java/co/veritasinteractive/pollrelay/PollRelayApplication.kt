package co.veritasinteractive.pollrelay

import android.app.Application
import android.content.res.AssetManager
import android.util.Log
import co.veritasinteractive.pollrelay.data.models.Region
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class PollRelayApplication(): Application() {
    override fun onCreate() {
        super.onCreate()
        val assetManager: AssetManager = assets
        val inputStream = assetManager.open("ug_data/ugdata.json")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val region: Region = Gson().fromJson(bufferedReader, Region::class.java)
        Log.d("MainActivity", region.toString())
    }
}
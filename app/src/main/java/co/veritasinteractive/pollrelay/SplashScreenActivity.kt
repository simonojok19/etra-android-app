package co.veritasinteractive.pollrelay

import android.content.Intent
import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import co.veritasinteractive.pollrelay.data.models.Region
import co.veritasinteractive.pollrelay.data.models.UgData
import co.veritasinteractive.pollrelay.login.LoginActivity
import co.veritasinteractive.pollrelay.workers.startWorkers
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        PollRelayRepository.getInstance(this)
        Handler().postDelayed(Runnable {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 2000)
    }
}
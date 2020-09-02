package co.veritasinteractive.pollrelay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import co.veritasinteractive.pollrelay.login.LoginActivity
import co.veritasinteractive.pollrelay.workers.startWorkers

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed(Runnable {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 2000)
    }
}
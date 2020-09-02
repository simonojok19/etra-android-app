package co.veritasinteractive.pollrelay

import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import co.veritasinteractive.pollrelay.data.models.UgData
import co.veritasinteractive.pollrelay.form.FormActivity
import co.veritasinteractive.pollrelay.workers.startWorkers
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        startWorkers(this)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
            startActivity(Intent(this, FormActivity::class.java))
        }
    }
}
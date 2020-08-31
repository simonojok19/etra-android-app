package co.veritasinteractive.pollrelay.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import co.veritasinteractive.pollrelay.R

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
    }

    fun selectRegion(view: View) {}
    fun selectDistrict(view: View) {}
    fun selectConstituency(view: View) {}
    fun selectSubCounty(view: View) {}
    fun selectParish(view: View) {}
    fun selectPollingStation(view: View) {}
    fun selectPosition(view: View) {}
}
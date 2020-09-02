package co.veritasinteractive.pollrelay.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import co.veritasinteractive.pollrelay.R
import co.veritasinteractive.pollrelay.data.models.District

class FormActivity : AppCompatActivity() {
    private lateinit var viewModel: FormActivityViewModel
    private lateinit var district: District
    private var CONSTITUENCY_REQUEST_CODE: Int = 676
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        viewModel = ViewModelProvider(this).get(FormActivityViewModel::class.java)
        district = viewModel.getDistrict()

    }
    fun selectConstituency(view: View) {

    }
    fun selectSubCounty(view: View) {}
    fun selectParish(view: View) {}
    fun selectPollingStation(view: View) {}
    fun selectPosition(view: View) {}
}
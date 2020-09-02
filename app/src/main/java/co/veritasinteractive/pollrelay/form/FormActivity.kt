package co.veritasinteractive.pollrelay.form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import co.veritasinteractive.pollrelay.R
import co.veritasinteractive.pollrelay.data.models.District
import co.veritasinteractive.pollrelay.dialogs.constituency.ConstituencySelectDialog
import kotlinx.android.synthetic.main.activity_form.*

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
        val intent = Intent(this, ConstituencySelectDialog::class.java)
        intent.putExtra(ConstituencySelectDialog.CONSTITUENCY, district.counties)
        startActivity(intent)
    }
    fun selectSubCounty(view: View) {}
    fun selectParish(view: View) {}
    fun selectPollingStation(view: View) {}
    fun selectPosition(view: View) {}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK &&  data != null) {
            when(requestCode) {
                CONSTITUENCY_REQUEST_CODE -> {
                    constituencyTextView.text = "Hello World"
                }
            }
        }
    }
}
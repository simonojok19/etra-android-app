package co.veritasinteractive.pollrelay.form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import co.veritasinteractive.pollrelay.R
import co.veritasinteractive.pollrelay.data.models.County
import co.veritasinteractive.pollrelay.data.models.District
import co.veritasinteractive.pollrelay.data.models.Parish
import co.veritasinteractive.pollrelay.data.models.SubCounty
import co.veritasinteractive.pollrelay.dialogs.constituency.ConstituencySelectDialogActivity
import co.veritasinteractive.pollrelay.dialogs.parish.ParishSelectActivity
import co.veritasinteractive.pollrelay.dialogs.polling_station.PollingStationSelectActivity
import co.veritasinteractive.pollrelay.dialogs.sub_county.SubCountySelectActivity
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {
    private lateinit var viewModel: FormActivityViewModel
    private lateinit var district: District
    private lateinit var county: County
    private lateinit var subCounty: SubCounty
    private lateinit var parish: Parish
    private lateinit var pollingStationName: String

    companion object {
        private const val CONSTITUENCY_REQUEST_CODE: Int = 676
        private const val SUB_COUNTY_REQUEST_CODE = 675
        private const val PARISH_REQUEST_CODE = 674
        private const val POLLING_STATION_REQUEST_CODE = 673
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        viewModel = ViewModelProvider(this).get(FormActivityViewModel::class.java)
        district = viewModel.getDistrict()
        selectSubCountyButton.isEnabled = false
        selectParishButton.isEnabled = false
        selectPollingStationButton.isEnabled = false
        positionSelectionBtn.isEnabled = false

    }
    fun selectConstituency(view: View) {
        val intent = Intent(this, ConstituencySelectDialogActivity::class.java)
        intent.putExtra(ConstituencySelectDialogActivity.CONSTITUENCY, district)
        startActivityForResult(intent, CONSTITUENCY_REQUEST_CODE)
    }
    fun selectSubCounty(view: View) {
        val intent = Intent(this, SubCountySelectActivity::class.java)
        intent.putExtra(SubCountySelectActivity.COUNTY, county)
        startActivityForResult(intent, SUB_COUNTY_REQUEST_CODE)
    }
    fun selectParish(view: View) {
        val intent = Intent(this, ParishSelectActivity::class.java)
        intent.putExtra(ParishSelectActivity.SUB_COUNTY, subCounty)
        startActivityForResult(intent, PARISH_REQUEST_CODE)
    }
    fun selectPollingStation(view: View) {
        val intent = Intent(this, PollingStationSelectActivity::class.java)
        intent.putExtra(PollingStationSelectActivity.PARISH, parish)
        startActivityForResult(intent, POLLING_STATION_REQUEST_CODE)
    }
    fun selectPosition(view: View) {}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("Form", "Returned")
        if (resultCode == RESULT_OK &&  data != null) {
            when(requestCode) {
                CONSTITUENCY_REQUEST_CODE -> {
                    county = data.getParcelableExtra<County>(ConstituencySelectDialogActivity.COUNTY)!!
                    constituencyTextView.text = county.name
                    selectSubCountyButton.isEnabled = true
                }

                SUB_COUNTY_REQUEST_CODE -> {
                    subCounty = data.getParcelableExtra<SubCounty>(SubCountySelectActivity.SUB_COUNTY)!!
                    subCountyTextView.text = subCounty.name
                    selectParishButton.isEnabled = true
                }

                PARISH_REQUEST_CODE -> {
                    parish = data.getParcelableExtra<Parish>(ParishSelectActivity.PARISH)!!
                    parishTextView.text = parish.name
                    selectPollingStationButton.isEnabled = true
                }

                POLLING_STATION_REQUEST_CODE -> {
                    pollingStationName =
                        data.getStringExtra(PollingStationSelectActivity.POLLING_STATION).toString()
                    pollingStationEditText.text = pollingStationName
                    positionSelectionBtn.isEnabled = true
                }
            }
        }
    }
}
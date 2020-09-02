package co.veritasinteractive.pollrelay.dialogs.polling_station

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.veritasinteractive.pollrelay.R
import co.veritasinteractive.pollrelay.data.models.Parish
import co.veritasinteractive.pollrelay.data.models.PollingStation
import kotlinx.android.synthetic.main.activity_polling_station_select.*

class PollingStationSelectActivity : AppCompatActivity(), PollingStationAdapter.OnPollingClickListener{

    companion object {
        val PARISH = "co.veritasinteractive.pollrelay.dialogs.polling_station.PollingStationSelectActivity.PARISH"
        val POLLING_STATION = "co.veritasinteractive.pollrelay.dialogs.polling_station.PollingStationSelectActivity.POLLING_STATION"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_polling_station_select)

        val recyclerView: RecyclerView = item_recycler_view
        val parish: Parish? = intent.getParcelableExtra<Parish>(PARISH)
        parish?.pollingstations?.let {
            val adapter = PollingStationAdapter(it, this)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

    }

    override fun onPollingStationClick(pollingStation: String) {
        val intent = Intent()
        intent.putExtra(POLLING_STATION, pollingStation)
        setResult(RESULT_OK, intent)
        finish()
    }
}
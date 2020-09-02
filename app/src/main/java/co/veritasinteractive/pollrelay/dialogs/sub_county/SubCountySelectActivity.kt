package co.veritasinteractive.pollrelay.dialogs.sub_county

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.veritasinteractive.pollrelay.R
import co.veritasinteractive.pollrelay.data.models.County
import co.veritasinteractive.pollrelay.data.models.SubCounty
import kotlinx.android.synthetic.main.activity_county_select.*

class SubCountySelectActivity : AppCompatActivity(), SubCountyAdapter.OnSubCountyClickListener {
    companion object {
        val COUNTY = "co.veritasinteractive.pollrelay.dialogs.sub_county.SubCountySelectActivity.COUNTY"
        val SUB_COUNTY = "co.veritasinteractive.pollrelay.dialogs.sub_county.SubCountySelectActivity.SUB_COUNTY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_county_select)
        val recyclerView: RecyclerView = item_recycler_view
        val county: County? = intent.getParcelableExtra<County>(COUNTY)

        county?.let {
            val adapter = it.subcounties?.let { it1 -> SubCountyAdapter(it1, this) }
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        }


    }

    override fun onSubCountyClick(subCounty: SubCounty) {
        val intent: Intent = Intent()
        intent.putExtra(SUB_COUNTY, subCounty)
        setResult(RESULT_OK, intent)
        finish()
    }
}
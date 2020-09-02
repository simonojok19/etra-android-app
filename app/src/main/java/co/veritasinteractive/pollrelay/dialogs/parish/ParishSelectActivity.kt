package co.veritasinteractive.pollrelay.dialogs.parish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.veritasinteractive.pollrelay.R
import co.veritasinteractive.pollrelay.data.models.Parish
import co.veritasinteractive.pollrelay.data.models.SubCounty
import kotlinx.android.synthetic.main.activity_parish_select.*

class ParishSelectActivity : AppCompatActivity(), ParishAdapter.OnParishClickListener {
    companion object {
        val SUB_COUNTY = "co.veritasinteractive.pollrelay.dialogs.parish.ParishSelectActivity.SUB_COUNTY"
        val PARISH = "co.veritasinteractive.pollrelay.dialogs.parish.ParishSelectActivity.PARISH"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parish_select)

        val recyclerView: RecyclerView = item_recycler_view
        val subCounty: SubCounty? = intent.getParcelableExtra<SubCounty>(SUB_COUNTY)
        subCounty?.parishs?.let {
            val adapter: ParishAdapter = ParishAdapter(it, this)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }

    override fun onParishClick(parish: Parish) {
        val intent = Intent()
        intent.putExtra(PARISH, parish)
        setResult(RESULT_OK, intent)
        finish()
    }
}
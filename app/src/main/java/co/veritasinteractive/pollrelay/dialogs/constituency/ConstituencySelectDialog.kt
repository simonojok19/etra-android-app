package co.veritasinteractive.pollrelay.dialogs.constituency

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.veritasinteractive.pollrelay.R
import co.veritasinteractive.pollrelay.data.models.County
import co.veritasinteractive.pollrelay.data.models.District
import kotlinx.android.synthetic.main.activity_constituency_sellect_dialog.*

class ConstituencySelectDialog : AppCompatActivity() {
    companion object {
        val CONSTITUENCY = "co.veritasinteractive.pollrelay.dialogs.constituency.ConstituencySelectDialog.CONSTITUENCY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constituency_sellect_dialog)

        val district: District? = intent.getParcelableExtra<District>(CONSTITUENCY)
        val recyclerView: RecyclerView = item_recycler_view

        district?.let {
            val adapter = it.counties?.let { it1 -> ConstituencyAdapter(it1, this) }
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }
}
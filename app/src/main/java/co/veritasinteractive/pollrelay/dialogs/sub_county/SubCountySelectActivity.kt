package co.veritasinteractive.pollrelay.dialogs.sub_county

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.veritasinteractive.pollrelay.R

class SubCountySelectActivity : AppCompatActivity() {
    companion object {
        val SUB_COUNTY = "co.veritasinteractive.pollrelay.dialogs.sub_county.SubCountySelectActivity.SUB_COUNTY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_county_select)
    }
}
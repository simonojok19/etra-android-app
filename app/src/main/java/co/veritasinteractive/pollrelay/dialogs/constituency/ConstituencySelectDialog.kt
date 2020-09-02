package co.veritasinteractive.pollrelay.dialogs.constituency

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.veritasinteractive.pollrelay.R

class ConstituencySelectDialog : Activity() {
    companion object {
        val CONSTITUENCY = "co.veritasinteractive.pollrelay.dialogs.constituency.ConstituencySelectDialog.CONSTITUENCY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constituency_sellect_dialog)
    }
}
package co.veritasinteractive.pollrelay.form

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import co.veritasinteractive.pollrelay.PollRelayRepository
import co.veritasinteractive.pollrelay.data.models.District

class FormActivityViewModel(application: Application): AndroidViewModel(application) {
    private var district: District
    init {
        val pollRelayRepository = PollRelayRepository.getInstance(application)
        district = pollRelayRepository.district
    }

    fun getDistrict(): District {
        return district
    }
}

package co.veritasinteractive.pollrelay.dialogs.polling_station

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.veritasinteractive.pollrelay.R
import co.veritasinteractive.pollrelay.data.models.PollingStation

class PollingStationAdapter(val pollingStations: Array<PollingStation>, val context: Context): RecyclerView.Adapter<PollingStationAdapter.PollingStationViewHolder>(){
    class PollingStationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PollingStationViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false)
        return PollingStationViewHolder(view)
    }

    override fun onBindViewHolder(holder: PollingStationViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return pollingStations.size
    }

    interface OnPollingClickListener {
        fun onPollingStationClick(pollingStation: PollingStation)
    }
}
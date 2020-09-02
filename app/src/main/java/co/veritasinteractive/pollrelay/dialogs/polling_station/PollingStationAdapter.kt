package co.veritasinteractive.pollrelay.dialogs.polling_station

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.veritasinteractive.pollrelay.R
import co.veritasinteractive.pollrelay.data.models.PollingStation

class PollingStationAdapter(private val pollingStations: Array<PollingStation>, val context: Context): RecyclerView.Adapter<PollingStationAdapter.PollingStationViewHolder>(){
    private val onPollingClickListener = context as OnPollingClickListener


    class PollingStationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.item_name)
        fun bind(
            pollingStation: PollingStation,
            onPollingClickListener: OnPollingClickListener
        ) {
            textView.text = pollingStation.name
            itemView.setOnClickListener {
                onPollingClickListener.onPollingStationClick(pollingStation)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PollingStationViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false)
        return PollingStationViewHolder(view)
    }

    override fun onBindViewHolder(holder: PollingStationViewHolder, position: Int) {
        holder.bind(pollingStations[position], onPollingClickListener)
    }

    override fun getItemCount(): Int {
        return pollingStations.size
    }

    interface OnPollingClickListener {
        fun onPollingStationClick(pollingStation: PollingStation)
    }
}
package co.veritasinteractive.pollrelay.dialogs.constituency

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.veritasinteractive.pollrelay.R
import co.veritasinteractive.pollrelay.data.models.County
import co.veritasinteractive.pollrelay.data.models.SubCounty

class ConstituencyAdapter(private val counties: Array<County>, val context: Context): RecyclerView.Adapter<ConstituencyAdapter.ConstituencyViewHolder>() {

    class ConstituencyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var initialView = itemView.findViewById<TextView>(R.id.item_initial)
        private var itemName = itemView.findViewById<TextView>(R.id.item_name)
        fun bind(county: County, position: Int) {
            initialView.text = position.toString()
            itemName.text = county.name
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConstituencyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false)
        return ConstituencyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConstituencyViewHolder, position: Int) {
        holder.bind(counties[position], position)
    }

    override fun getItemCount(): Int {
        return counties.size
    }
}
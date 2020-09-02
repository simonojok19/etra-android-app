package co.veritasinteractive.pollrelay.dialogs.constituency

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.veritasinteractive.pollrelay.R
import co.veritasinteractive.pollrelay.data.models.County

class ConstituencyAdapter(private val counties: Array<County>, val context: Context): RecyclerView.Adapter<ConstituencyAdapter.ConstituencyViewHolder>() {
    private val onItemClickListener: OnItemClickListener = context as OnItemClickListener

    class ConstituencyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var itemName = itemView.findViewById<TextView>(R.id.item_name)
        fun bind(county: County, onItemClickListener: OnItemClickListener) {
            itemName.text = county.name
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(county)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConstituencyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false)
        return ConstituencyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConstituencyViewHolder, position: Int) {
        holder.bind(counties[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return counties.size
    }

    public interface OnItemClickListener {
        fun onItemClick(county: County)
    }
}
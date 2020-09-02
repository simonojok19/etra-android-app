package co.veritasinteractive.pollrelay.dialogs.constituency.sub_county

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.veritasinteractive.pollrelay.R
import co.veritasinteractive.pollrelay.data.models.SubCounty

class SubCountyAdapter (private val subCounties: Array<SubCounty>, val context: Context): RecyclerView.Adapter<SubCountyAdapter.SubCountyViewHolder>(){
    private val onSubCountyClickListener: OnSubCountyClickListener = context as OnSubCountyClickListener

    class SubCountyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById<TextView>(R.id.item_name)
        fun bind(
            subCounty: SubCounty,
            onSubCountyClickListener: OnSubCountyClickListener
        ) {
            textView.text = subCounty.name
            textView.setOnClickListener {
                onSubCountyClickListener.onSubCountyClick(subCounty)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCountyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false)
        return SubCountyViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubCountyViewHolder, position: Int) {
        holder.bind(subCounties[position], onSubCountyClickListener)
    }

    override fun getItemCount(): Int {
        return subCounties.size
    }

    public interface OnSubCountyClickListener {
        fun onSubCountyClick(subCounty: SubCounty)
    }
}
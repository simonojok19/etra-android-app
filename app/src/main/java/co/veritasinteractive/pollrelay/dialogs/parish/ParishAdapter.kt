package co.veritasinteractive.pollrelay.dialogs.parish

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.veritasinteractive.pollrelay.R
import co.veritasinteractive.pollrelay.data.models.Parish

class ParishAdapter(private val parishs: Array<Parish>, val context: Context): RecyclerView.Adapter<ParishAdapter.ParishViewHolder> (){
    private var onParishClickListener = context as OnParishClickListener
    class ParishViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.item_name)

        fun bind(parish: Parish, onParishClickListener: OnParishClickListener) {
            itemView.setOnClickListener {
                textView.text = parish.name
                onParishClickListener.onParishClick(parish)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParishViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false)
        return ParishViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParishViewHolder, position: Int) {
        holder.bind(parishs[position], onParishClickListener)
    }

    override fun getItemCount(): Int {
        return parishs.size
    }

    public interface OnParishClickListener {
        fun onParishClick(parish: Parish)
    }
}
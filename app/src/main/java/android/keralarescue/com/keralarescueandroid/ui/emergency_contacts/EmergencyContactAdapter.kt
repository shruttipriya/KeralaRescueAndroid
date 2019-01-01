package android.keralarescue.com.keralarescueandroid.ui.emergency_contacts

import android.keralarescue.com.keralarescueandroid.R
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.emergency_contact_lvi.view.*

class EmergencyContactAdapter(var dataSet: List<String>): RecyclerView.Adapter<EmergencyContactAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.emergency_contact_lvi, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = dataSet[position]
    }

    ///////////////////////////////////////

    fun setSectionList(sectionList: List<String>) {
        dataSet = sectionList
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val title = view.title

    }
}
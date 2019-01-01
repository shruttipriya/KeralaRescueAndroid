package android.keralarescue.com.keralarescueandroid.ui.lvi

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.util.*

class LviAdapter (val list: List<Lvi<*>>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
    //    list.size
        return 0;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      //  list[position].bindViewHolder(holder, position)
    }


    /**
     * Update current adapter list of items then notify data change
     * @param list to be updated
     */
    fun updateList(updateList: ArrayList<Lvi<*>>) {
//        list = updateList
//        notifyDataSetChanged()
    }

    /**
     * Get list of Lvi items
     * @return lvi list
     */
    fun getItems(): List<Lvi<*>> {
        return list
    }

    /**
     * Get Lvi at this position in the adapter list
     * @param position
     * @return
     */
    private fun getItem(position: Int): Lvi<*> {
        return list[position]
    }
}


package android.keralarescue.com.keralarescueandroid.ui.resuephotos

import android.keralarescue.com.keralarescueandroid.R
import android.keralarescue.com.keralarescueandroid.util.firebase.FireBaseModels
import android.keralarescue.com.keralarescueandroid.util.firebase.FirebaseStorageManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.rescue_photo_lvi.view.*

class RescuePhotoAdapter(private var myDataset: List<FireBaseModels.RescuePhoto>) :
        RecyclerView.Adapter<RescuePhotoAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.rescue_photo_lvi, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = myDataset.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = myDataset[position].name
        FirebaseStorageManager.loadImageToImageView(holder.imageView, myDataset[position])
    }

    ///////////////////////////////////////

    fun setRescuePhotoList(rescuePhotoList: List<FireBaseModels.RescuePhoto>) {
        myDataset = rescuePhotoList
    }

    //////////////////////////////////////

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.rescue_photos_image
        val textView = view.rescue_photos_text
    }
}
package android.keralarescue.com.keralarescueandroid.ui.resuephotos

import android.content.Context
import android.content.Intent
import android.keralarescue.com.keralarescueandroid.R
import android.keralarescue.com.keralarescueandroid.util.firebase.FireBaseModels
import android.keralarescue.com.keralarescueandroid.util.firebase.FirebaseJavaManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.rescue_photo_activity.*

class RescuePhotosActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var rescuePhotoListDataSet = listOf<FireBaseModels.RescuePhoto>()
    private val viewAdapter: RescuePhotoAdapter = RescuePhotoAdapter(rescuePhotoListDataSet)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rescue_photo_activity)
        recyclerView = rescue_photo_recycleview

        setUpActionBar()
        initRecycleView()

    }

    override fun onStart() {
        super.onStart()
        fetchPhotos()

    }

    ////////////////////////////////////////////

    private fun fetchPhotos() {
        FirebaseJavaManager.loadRescuePhotos("heros_of_India") {
            rescuePhotoListDataSet = it as List<FireBaseModels.RescuePhoto>
            viewAdapter.setRescuePhotoList(rescuePhotoListDataSet)
            viewAdapter.notifyDataSetChanged()
        }
    }

    private fun initRecycleView() {
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.apply {
            adapter = viewAdapter
        }
    }

    private fun setUpActionBar() {
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.rescue_photos)
    }


    ///////////////////////////////////////////

    companion object {
        fun getNewIntent(context: Context): Intent {
            return Intent(context, RescuePhotosActivity::class.java)
        }
    }
}
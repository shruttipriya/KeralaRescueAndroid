package android.keralarescue.com.keralarescueandroid.ui.prepare

import android.content.Context
import android.content.Intent
import android.keralarescue.com.keralarescueandroid.R
import android.keralarescue.com.keralarescueandroid.ui.lvi.Lvi
import android.keralarescue.com.keralarescueandroid.ui.lvi.LviAdapter
import android.keralarescue.com.keralarescueandroid.util.firebase.FireBaseModels
import android.keralarescue.com.keralarescueandroid.util.firebase.FirebaseJavaManager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import kotlinx.android.synthetic.main.prepare_activity.*
import java.util.ArrayList

class PrepareActivity: AppCompatActivity() {

    private var mHomeItemsList = mutableListOf<Lvi<*>>()

    companion object {
        fun getNewIntent(context: Context): Intent {
            val intent = Intent(context, PrepareActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.prepare_activity)

        val callback =
                FirebaseJavaManager.FireBaseCallback<FireBaseModels.PrepareInfoModel> {
            Toast.makeText(this, "Success,", Toast.LENGTH_SHORT).show()

        }


       FirebaseJavaManager.loadBeforeTheFlood("prepare/flood/english/topics/before_flood",
               callback)
    }

    /////////////////////////////////////////

    private fun initUI() {
        prepare_recycleview.layoutManager = LinearLayoutManager(this)


       // mHomeItemsList.add(PrepareHeader())

        prepare_recycleview.adapter = LviAdapter(mHomeItemsList)


    }
}
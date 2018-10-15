package android.keralarescue.com.keralarescueandroid.ui.prepare

import android.content.Context
import android.content.Intent
import android.keralarescue.com.keralarescueandroid.R
import android.keralarescue.com.keralarescueandroid.util.firebase.FireBaseModels
import android.keralarescue.com.keralarescueandroid.util.firebase.FirebaseJavaManager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class PrepareActivity: AppCompatActivity() {

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

    }
}
package android.keralarescue.com.keralarescueandroid.ui.resuephotos

import android.content.Context
import android.content.Intent
import android.keralarescue.com.keralarescueandroid.R
import android.keralarescue.com.keralarescueandroid.util.firebase.FireBaseModels
import android.keralarescue.com.keralarescueandroid.util.firebase.FirebaseJavaManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.internal.FirebaseAppHelper
import timber.log.Timber

class RescuePhotosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rescue_photo_activity)
    }

    override fun onStart() {
        super.onStart()
        fetchPhotos()
    }

    ////////////////////////////////////////////

    private fun fetchPhotos() {
        FirebaseJavaManager.loadRescuePhotos("heros_of_India") {
            val models: List<FireBaseModels.RescuePhoto> = it as List<FireBaseModels.RescuePhoto>
            for (model in models) {
                Timber.d("JOJO :: "+ model.name)
            }
        }
    }

    ///////////////////////////////////////////

    companion object {
        fun getNewIntent(context: Context): Intent {
            return Intent(context, RescuePhotosActivity::class.java)
        }
    }
}
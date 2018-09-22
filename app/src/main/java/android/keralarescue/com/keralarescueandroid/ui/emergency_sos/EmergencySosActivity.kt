package android.keralarescue.com.keralarescueandroid.ui.emergency_sos

import android.content.Context
import android.content.Intent
import android.keralarescue.com.keralarescueandroid.R
import android.keralarescue.com.keralarescueandroid.ui.base.BaseActivity
import android.keralarescue.com.keralarescueandroid.util.FLashUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_emergency_sos.*
import timber.log.Timber

class EmergencySosActivity: BaseActivity() {

    val  flashManager = FLashUtil()

    companion object {
        fun getNewIntent(context: Context): Intent {
            val intent = Intent(context, EmergencySosActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_sos)
        initUI()
    }

    override fun onStart() {
        super.onStart()
        flashManager.init(this)
    }

    override fun onStop() {
        super.onStop()
        flashManager.destroy()
    }

    //////////////////////////////////////////////////

    private fun initUI() {
        flash_light.setOnClickListener({
            Timber.d("Toggling camera flash")
            flashManager.toggleFlash()

        })
    }
}
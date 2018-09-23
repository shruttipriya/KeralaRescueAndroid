package android.keralarescue.com.keralarescueandroid.ui.emergency_sos

import android.content.Context
import android.content.Intent
import android.keralarescue.com.keralarescueandroid.R
import android.keralarescue.com.keralarescueandroid.ui.base.BaseActivity
import android.keralarescue.com.keralarescueandroid.util.FLashUtil
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_emergency_sos.*
import timber.log.Timber

class EmergencySosActivity: BaseActivity() {

    private val  flashManager = FLashUtil()

    companion object {
        fun getNewIntent(context: Context): Intent {
            val intent = Intent(context, EmergencySosActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_sos)

        setUpActionBar()
    }

    override fun onStart() {
        super.onStart()
        flashManager.init(this)

        initUI()
    }

    override fun onStop() {
        super.onStop()
        flashManager.destroy()
    }

    //////////////////////////////////////////////////

    private fun setUpActionBar() {
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.emergency_sos)
    }

    private fun initUI() {
        flash_light_btn.text = getString(R.string.flashlight)

        //TODO need to figure out if flash is enabled or not and enable switch
        flash_light_btn.setOnCheckedChangeListener({ buttonView, isChecked ->
            if (isChecked) {
                flashManager.turnOnFLash()
            } else {
                flashManager.tuenOffFlash()
            }
        })

        strobe_light_btn.setOnCheckedChangeListener({buttonView, isChecked ->
            //TODO set Strobe light
            if (isChecked) {

            } else {
                
            }
        })


        // TODO Remove
        flash_light.setOnClickListener({
            Timber.d("Toggling camera flash")
            flashManager.toggleFlash()
        })
    }
}
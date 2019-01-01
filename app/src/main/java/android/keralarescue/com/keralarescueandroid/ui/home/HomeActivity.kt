package android.keralarescue.com.keralarescueandroid.ui.home

import android.content.Context
import android.content.Intent
import android.keralarescue.com.keralarescueandroid.R
import android.keralarescue.com.keralarescueandroid.ui.emergency_contacts.EmergencyContactsActivity
import android.keralarescue.com.keralarescueandroid.ui.emergency_sos.EmergencySosActivity
import android.keralarescue.com.keralarescueandroid.ui.prepare.PrepareActivity
import android.keralarescue.com.keralarescueandroid.ui.resuephotos.RescuePhotosActivity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity:AppCompatActivity() {

    companion object {
        fun getNewIntent(context: Context): Intent {
            val intent = Intent(context, HomeActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initUI()
    }

    ///////////////////////////////////////////////////

    private fun toastComingSoon() {
        Toast.makeText(this, "Coming Soon",Toast.LENGTH_SHORT).show()
    }

    private fun initUI() {

        emergency_sos_btn.setOnClickListener {
            startActivity(EmergencySosActivity.getNewIntent(this))
        }

        prepare_btn.setOnClickListener {
            startActivity(PrepareActivity.getNewIntent(this))
        }
        after_a_flood_btn.setOnClickListener { this.toastComingSoon() }
        emergency_contact_btn.setOnClickListener {
            startActivity(EmergencyContactsActivity.getNewIntent(this))
        }
        rescue_photos_btn.setOnClickListener {
            startActivity(RescuePhotosActivity.getNewIntent(this))
        }
    }


}
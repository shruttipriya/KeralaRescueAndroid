package android.keralarescue.com.keralarescueandroid.ui.home

import android.content.Context
import android.content.Intent
import android.keralarescue.com.keralarescueandroid.R
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
        emergency_sos_btn.setOnClickListener({
            //TODO
            this.toastComingSoon()
        })

        prepare_btn.setOnClickListener { this.toastComingSoon() }
        after_a_flood_btn.setOnClickListener { this.toastComingSoon() }
        emergency_contact_btn.setOnClickListener { this.toastComingSoon() }
        rescue_photos_btn.setOnClickListener { this.toastComingSoon() }

    }


}
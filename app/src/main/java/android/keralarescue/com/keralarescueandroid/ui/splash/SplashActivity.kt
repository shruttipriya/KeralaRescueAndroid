package android.keralarescue.com.keralarescueandroid.ui.splash

import android.keralarescue.com.keralarescueandroid.R
import android.keralarescue.com.keralarescueandroid.ui.home.HomeActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    private var timerHandler = Handler()
    private val TIME_DELAY: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        //TODO need to remove Action bar from themes
        val actionBar = supportActionBar
        actionBar!!.hide()
    }

    override fun onStart() {
        super.onStart()
        timerHandler?.postDelayed(this::navigateToHome , TIME_DELAY)
    }

    override fun onPause() {
        super.onPause()
        timerHandler.removeCallbacksAndMessages(null)
    }

    /////////////////////////////////////////////////////

    private fun navigateToHome() {
        startActivity(HomeActivity.getNewIntent(this))
        finish()
    }
}

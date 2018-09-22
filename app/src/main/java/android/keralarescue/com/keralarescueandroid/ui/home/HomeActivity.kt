package android.keralarescue.com.keralarescueandroid.ui.home

import android.content.Context
import android.content.Intent
import android.keralarescue.com.keralarescueandroid.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

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
    }

    ////////////////////////////////////////////////////
}
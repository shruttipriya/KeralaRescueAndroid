package android.keralarescue.com.keralarescueandroid

import android.app.Application
import android.keralarescue.com.keralarescueandroid.util.logging.NoLoggingTree
import timber.log.Timber

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        setUpTimber()
    }

    private fun setUpTimber() {
        if (!BuildConfig.DEBUG) {
            Timber.plant(NoLoggingTree())
        } else {
            Timber.plant(Timber.DebugTree())
        }
    }
}
package android.keralarescue.com.keralarescueandroid.util.logging

import timber.log.Timber

class NoLoggingTree: Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        //Not logging
    }
}
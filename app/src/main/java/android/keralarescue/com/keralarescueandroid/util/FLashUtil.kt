package android.keralarescue.com.keralarescueandroid.util

import android.content.Context
import com.noob.noobcameraflash.managers.NoobCameraManager

class FLashUtil {
    /**
     * Initialize Flash Lib, Need to call release before leaving Activity
     */
    fun init(context: Context) {
        NoobCameraManager.getInstance().init(context)
    }

    fun destroy() {
        NoobCameraManager.getInstance().release()
    }

    fun turnOnFLash() {
        NoobCameraManager.getInstance().turnOnFlash();
    }

    fun tuenOffFlash() {
        NoobCameraManager.getInstance().turnOffFlash();
    }

    fun toggleFlash() {
        NoobCameraManager.getInstance().toggleFlash()
    }

}
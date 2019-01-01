package android.keralarescue.com.keralarescueandroid.util.firebase

import android.support.annotation.IntegerRes

class FireBaseModels {

    //Prepare
    data class ChildPrepareModel (
            val title:String = "",
            val sort:Int = -1,
            val details: List<String> = listOf()
    )

    data class PrepareInfoModel (
        val title:String ="",
        val sort:Int = -1,
        val likely_to_hit: ChildPrepareModel? = null,
        val prepare_evaculation:ChildPrepareModel? = null

    )

    data class Sample(
            val key: String? = null
    )

    data class RescuePhoto(
            val id: String? = "",
            val name:String? = "",
            val story: String? = "",
            val url:String? = ""
    )

}
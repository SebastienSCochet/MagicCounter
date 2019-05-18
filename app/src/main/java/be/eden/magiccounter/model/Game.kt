package be.eden.magiccounter.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
class Game {

    val creationTime = LocalDateTime.now()
    var finishTime : LocalTime? = null
    var time : Long? = null


    fun finish(){
        finishTime = LocalTime.now()
    }
}
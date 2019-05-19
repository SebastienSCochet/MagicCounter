package be.eden.magiccounter.model

import org.joda.time.DateTime
import org.joda.time.Duration

class Game {

    private val creationTime : DateTime = DateTime.now()
    private var finishTime : DateTime? = null
    private var totalDuration : Duration? = null

    /**
     * Finish the game.
     */
    fun finish(){
        finishTime = DateTime.now()
        totalDuration = Duration(creationTime, finishTime)
    }

    /**
     * Returns the totalDuration from now.
     */
    fun durationString() : String {
        val duration = Duration(creationTime, DateTime.now())
        return "${duration.standardHours%24}H ${duration.standardMinutes%60}m ${duration.standardSeconds%60}s"
    }
}
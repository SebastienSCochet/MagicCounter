package be.eden.magiccounter.view.game

import be.eden.magiccounter.model.Event
import be.eden.magiccounter.model.Player
import be.eden.magiccounter.view.base.View

interface GameView : View {
    fun initializeNames(player1Name: String, player2Name: String)
    fun initializeScore(maxScore: Int)
    fun editPlayer1Score(score : Int)
    fun editPlayer2Score(score : Int)
    fun displayDuration(duration : String)
    fun updateEvents(events : List<Event>)
    fun initializeLongPressListener(players: Array<Player>)
}
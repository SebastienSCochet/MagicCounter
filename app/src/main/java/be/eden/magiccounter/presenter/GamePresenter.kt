package be.eden.magiccounter.presenter

import android.content.Context
import be.eden.magiccounter.enumeration.EventType
import be.eden.magiccounter.model.Event
import be.eden.magiccounter.model.Game
import be.eden.magiccounter.model.Player
import be.eden.magiccounter.util.PreferencesHelper
import be.eden.magiccounter.view.game.GameView

class GamePresenter(private val view : GameView) : Presenter {

    private lateinit var preferencesHelper : PreferencesHelper

    private val game = Game()
    private lateinit var players : Array<Player>
    private var events = arrayListOf<Event>()

    fun retrieveFields(context: Context) {

        preferencesHelper = PreferencesHelper(context)

        val player1Name = preferencesHelper.player1Name
        val player2Name = preferencesHelper.player2Name
        val maxScore = preferencesHelper.maxScore

        view.initializeNames(player1Name, player2Name)
        view.initializeScore(maxScore)

        players = arrayOf(
            Player(player1Name, maxScore),
            Player(player2Name, maxScore)
        )

        events.add(Event(type = EventType.START))
        view.updateEvents(events)
    }

    fun changeLifePlayer1(damage : Int) {
        view.editPlayer1Score(players[0].handleDamage(damage))
        if(players[0].points == 0) {
            game.finish()
            view.displayDuration(game.durationString())

            events.add(Event(player = players[1], type = EventType.VICTORY))
            view.updateEvents(events)
        }
    }

    fun changeLifePlayer2(damage : Int) {
        view.editPlayer2Score(players[1].handleDamage(damage))
        if(players[1].points == 0) {
            game.finish()
            view.displayDuration(game.durationString())

            events.add(Event(player = players[0], type = EventType.VICTORY))
            view.updateEvents(events)
        }
    }
}
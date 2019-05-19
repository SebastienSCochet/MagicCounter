package be.eden.magiccounter.presenter

import android.content.Context
import be.eden.magiccounter.enumeration.PlayerNumber
import be.eden.magiccounter.helper.PreferencesHelper
import be.eden.magiccounter.model.*
import be.eden.magiccounter.view.game.GameView

class GamePresenter(private val view : GameView) : Presenter {

    private lateinit var preferencesHelper : PreferencesHelper

    private val game = Game()
    private lateinit var players : Array<Player>
    private val eventManager = EventManager()

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

        view.initializeLongPressListener(players)

        eventManager.start()
        eventManager.firstMove(players)

        view.updateEvents(eventManager.events)
    }

    fun changeLifePoints(playerNumber: PlayerNumber, damage: Int) {
        val player : Player
        val other : Player

        when(playerNumber){
            PlayerNumber.PLAYER1 -> {
                player = players[0]
                other = players[1]
            }
            PlayerNumber.PLAYER2 -> {
                player = players[1]
                other = players[0]
            }
        }

        val points = player.handleDamage(damage)

        when(playerNumber){
            PlayerNumber.PLAYER1 -> view.editPlayer1Score(points)
            PlayerNumber.PLAYER2 -> view.editPlayer2Score(points)
        }

        eventManager.damage(player, damage)

        if(player.points <= 0) {
            game.finish()
            view.displayDuration(game.durationString())

            eventManager.victory(other)
        }

        view.updateEvents(eventManager.events)
    }
}
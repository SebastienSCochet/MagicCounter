package be.eden.magiccounter.presenter

import android.content.Context
import be.eden.magiccounter.model.Player
import be.eden.magiccounter.util.PreferencesHelper
import be.eden.magiccounter.view.GameView

class GamePresenter(private val view : GameView) : Presenter {

    private lateinit var preferencesHelper : PreferencesHelper

    private lateinit var players : Array<Player>

    fun retrieveFields(context: Context) {

        preferencesHelper = PreferencesHelper(context)

        val player1Name = preferencesHelper.player1Name
        val player2Name = preferencesHelper.player2Name
        val maxScore = preferencesHelper.maxScore

        view.initializeFields(player1Name, player2Name)

        players = arrayOf(
            Player(player1Name, maxScore),
            Player(player2Name, maxScore)
        )
    }
}
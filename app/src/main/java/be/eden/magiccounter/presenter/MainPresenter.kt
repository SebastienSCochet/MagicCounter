package be.eden.magiccounter.presenter

import android.content.Context
import be.eden.magiccounter.helper.PreferencesHelper
import be.eden.magiccounter.view.main.MainView

class MainPresenter(private val view : MainView) : Presenter {

    private lateinit var preferencesHelper : PreferencesHelper

    fun onStart(context: Context){
        preferencesHelper = PreferencesHelper(context)

        retrievesFields()
    }

    private fun retrievesFields() {
        view.initializeFields(
            preferencesHelper.player1Name,
            preferencesHelper.player2Name,
            preferencesHelper.maxScore
        )
    }

    fun saveFields(player1Name : String, player2Name: String, maxScore : Int) {
        preferencesHelper.player1Name = player1Name
        preferencesHelper.player2Name = player2Name
        preferencesHelper.maxScore = maxScore
    }
}
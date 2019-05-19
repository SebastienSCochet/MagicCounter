package be.eden.magiccounter.view.main

import be.eden.magiccounter.view.base.View


interface MainView : View {
    fun initializeFields(player1Name : String, player2Name : String, maxScore : Int)
    fun showToast(text: String)
    fun startGameActivity()
}
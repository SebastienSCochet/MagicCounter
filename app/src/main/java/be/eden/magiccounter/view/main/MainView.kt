package be.eden.magiccounter.view.main

import be.eden.magiccounter.view.base.View


interface MainView : View {
    fun showToast(text: String)
    fun startGameActivity()
}
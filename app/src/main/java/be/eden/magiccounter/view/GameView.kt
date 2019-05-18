package be.eden.magiccounter.view

interface GameView : View {
    fun initializeFields(player1Name: String, player2Name: String)
}
package be.eden.magiccounter.model

data class Player(val name : String, var points : Int) {

    companion object {
        var NUMBER_OF_PLAYERS = 0
    }

    var number : Int = 0

    init {
        ++NUMBER_OF_PLAYERS
        number = NUMBER_OF_PLAYERS
    }

    /**
     * Increase or decrease life points of the player.
     */
    fun handleDamage(damage : Int) : Int {
        points += damage
        return points
    }
}

package be.eden.magiccounter.model

data class Player(val name : String, var points : Int) {

    /**
     * Increase or decrease life points of the player.
     */
    fun handleDamage(damage : Int) : Int {
        points += damage
        return points
    }
}

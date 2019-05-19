package be.eden.magiccounter.model

import be.eden.magiccounter.enumeration.PlayerNumber

interface DamageSendListener {
    fun onDamageSend(playerNumber: PlayerNumber, damage : Int)
}
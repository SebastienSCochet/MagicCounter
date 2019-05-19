package be.eden.magiccounter.model

import be.eden.magiccounter.enumeration.EventType

class Event (
    private val player : Player? = null,
    private val damages : Int? = null,
    private val type : EventType
) {
    override fun toString(): String {
        return when (type) {
            EventType.START -> "C'est l'heure du Du-du-du-du-du-duel !"

            EventType.MOVE -> "${player?.name} commence."

            EventType.DAMAGE -> {
                if(damages != null){
                    if(damages < 0) {
                        "${player?.name} a subis ${damages*-1} points de dégâts."
                    } else {
                        "${player?.name} a gagné $damages points de vie."
                    }
                } else "${player?.name} n'a subis aucun dégâts."
            }

            EventType.VICTORY -> "${player?.name} a remporté la victoire !"
        }
    }
}
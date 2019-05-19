package be.eden.magiccounter.model

import be.eden.magiccounter.enumeration.EventType

class EventManager {
    val events = arrayListOf<Event>()
    var gameFinish = false

    fun start() {
        events.add(0, Event(type = EventType.START))
    }

    fun damage(player : Player, damages : Int) {
        events.add(0, Event(player, damages, EventType.DAMAGE))
    }

    fun firstMove(players : Array<Player>) {
        val random : Int = 1 + (Math.random() * 10).toInt()

        val first = if(random <= 5) {
            players[0]
        } else {
            players[1]
        }
        events.add(0, Event(type = EventType.MOVE, player = first))
    }

    fun victory(player: Player) {
        if(!gameFinish){
            events.add(0, Event(type = EventType.VICTORY, player = player))
            gameFinish = true
        }
    }
}
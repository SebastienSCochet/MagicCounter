package be.eden.magiccounter.view.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import be.eden.magiccounter.R
import be.eden.magiccounter.model.Event
import be.eden.magiccounter.model.Player
import be.eden.magiccounter.enumeration.PlayerNumber
import be.eden.magiccounter.enumeration.PointType
import be.eden.magiccounter.model.DamageSendListener
import be.eden.magiccounter.presenter.GamePresenter
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity(), GameView, DamageSendListener {
    private val presenter = GamePresenter(this)
    lateinit var gameEvents : ListView

    private fun initializeFields() {
        this.gameEvents = findViewById(R.id.gameEvents)
        this.gameEvents.adapter = ArrayAdapter<Event>(this, android.R.layout.simple_list_item_1, emptyArray())

        gamePlayer1PlusButton.setOnClickListener { presenter.changeLifePoints(PlayerNumber.PLAYER1, +1) }
        gamePlayer1MinusButton.setOnClickListener { presenter.changeLifePoints(PlayerNumber.PLAYER1, -1) }
        gamePlayer2PlusButton.setOnClickListener { presenter.changeLifePoints(PlayerNumber.PLAYER2, +1) }
        gamePlayer2MinusButton.setOnClickListener { presenter.changeLifePoints(PlayerNumber.PLAYER2, -1) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        setSupportActionBar(findViewById(R.id.gameToolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeFields()

        presenter.retrieveFields(this)
    }

    override fun initializeLongPressListener(players : Array<Player>) {
        gamePlayer1PlusButton.setOnLongClickListener{
            DamageDialog(PointType.HEAL, PlayerNumber.PLAYER1, this).show(supportFragmentManager, "Damage Dialog")
            true
        }
        gamePlayer1MinusButton.setOnLongClickListener{
            DamageDialog(PointType.DAMAGE, PlayerNumber.PLAYER1, this).show(supportFragmentManager, "Damage Dialog")
            true
        }
        gamePlayer2PlusButton.setOnLongClickListener{
            DamageDialog(PointType.HEAL, PlayerNumber.PLAYER2, this).show(supportFragmentManager, "Damage Dialog")
            true
        }
        gamePlayer2MinusButton.setOnLongClickListener{
            DamageDialog(PointType.DAMAGE, PlayerNumber.PLAYER2, this).show(supportFragmentManager, "Damage Dialog")
            true
        }
    }

    override fun onDamageSend(playerNumber: PlayerNumber, damage: Int) {
        presenter.changeLifePoints(playerNumber, damage)
    }

    override fun initializeNames(player1Name : String, player2Name : String){
        gamePlayer1Name.text = player1Name
        gamePlayer2Name.text = player2Name
    }

    override fun initializeScore(maxScore : Int) {
        gamePlayer1Score.text = maxScore.toString()
        gamePlayer2Score.text = maxScore.toString()
    }

    override fun editPlayer1Score(score: Int) {
        gamePlayer1Score.text = score.toString()
    }

    override fun editPlayer2Score(score: Int) {
        gamePlayer2Score.text = score.toString()
    }

    override fun displayDuration(duration: String) {
        gameDuration.text = duration
    }

    override fun updateEvents(events: List<Event>) {
        this.gameEvents.adapter = ArrayAdapter<Event>(this, android.R.layout.simple_list_item_1, events)
    }
}

package be.eden.magiccounter.view.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import be.eden.magiccounter.R
import be.eden.magiccounter.model.Event
import be.eden.magiccounter.presenter.GamePresenter
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity(), GameView {

    private val presenter = GamePresenter(this)
    lateinit var gameEvents : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        setSupportActionBar(findViewById(R.id.gameToolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeFields()

        presenter.retrieveFields(this)
    }

    private fun initializeFields() {
        gamePlayer1PlusButton.setOnClickListener { presenter.changeLifePlayer1(+1) }
        gamePlayer1MinusButton.setOnClickListener { presenter.changeLifePlayer1(-1) }
        gamePlayer2PlusButton.setOnClickListener { presenter.changeLifePlayer2(+1) }
        gamePlayer2MinusButton.setOnClickListener { presenter.changeLifePlayer2(-1) }

        this.gameEvents = findViewById(R.id.gameEvents)
        this.gameEvents.adapter = ArrayAdapter<Event>(this, android.R.layout.simple_list_item_1, emptyArray())
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

package be.eden.magiccounter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import be.eden.magiccounter.R
import be.eden.magiccounter.presenter.GamePresenter
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity(), GameView {

    private val presenter = GamePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        presenter.retrieveFields(this)
    }

    override fun initializeFields(player1Name : String, player2Name : String){
        gamePlayer1Name.text = player1Name
        gamePlayer2Name.text = player2Name
    }


}

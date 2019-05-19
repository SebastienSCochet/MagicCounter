package be.eden.magiccounter.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import be.eden.magiccounter.R
import be.eden.magiccounter.presenter.MainPresenter
import be.eden.magiccounter.view.game.GameActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onStart(this)
        mainStartButton.setOnClickListener {

            val name1 = mainNamePlayer1Edit.text.toString()
            val name2 = mainNamePlayer2Edit.text.toString()
            val maxScore = mainNumberPointsEdit.text.toString()

            if(name1.isEmpty() or name2.isEmpty() or maxScore.isEmpty()){
                showToast(getString(R.string.main_fill_all))
            } else {
                presenter.saveFields(
                    name1,
                    name2,
                    maxScore.toInt()
                )

                startGameActivity()
            }

        }
    }

    override fun initializeFields(player1Name: String, player2Name: String, maxScore: Int) {
        mainNamePlayer1Edit.setText(player1Name)
        mainNamePlayer2Edit.setText(player2Name)
        mainNumberPointsEdit.setText(maxScore.toString())
    }

    override fun showToast(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun startGameActivity() {
        startActivity(Intent(applicationContext, GameActivity::class.java))
    }
}

package com.eliasfang.mymemory

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.eliasfang.mymemory.models.BoardSize
import com.eliasfang.mymemory.utils.EXTRA_BOARD_SIZE

class HomeActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "HomeActivity"
    }

    private lateinit var cvEasy: CardView
    private lateinit var cvMedium: CardView
    private lateinit var cvHard: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()

        cvEasy = findViewById(R.id.cvEasy)
        cvMedium = findViewById(R.id.cvMedium)
        cvHard = findViewById(R.id.cvHard)

        cvEasy.setOnClickListener {
            startMainActivity(BoardSize.EASY)
        }
        cvMedium.setOnClickListener {
            startMainActivity(BoardSize.MEDIUM)
        }

        cvHard.setOnClickListener {
            startMainActivity(BoardSize.HARD)
        }
    }

    private fun startMainActivity(desiredBoardSize: BoardSize) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(EXTRA_BOARD_SIZE, desiredBoardSize)
        startActivity(intent)
    }

}
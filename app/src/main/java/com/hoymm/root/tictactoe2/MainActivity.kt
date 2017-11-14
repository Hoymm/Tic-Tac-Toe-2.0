package com.hoymm.root.tictactoe2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.MainMenuDisplay

/**
 * Created by Damian Muca - Kaizen (12.09.17)
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        startActivity(Intent(this, MainMenuDisplay::class.java))
        finish()
    }

}

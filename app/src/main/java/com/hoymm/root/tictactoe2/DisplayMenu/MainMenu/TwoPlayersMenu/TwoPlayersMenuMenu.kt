package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.TwoPlayersMenu

import android.content.Intent
import android.support.v7.app.AppCompatActivity

import com.hoymm.root.tictactoe2.DisplayMenu.DisplayMenu
import com.hoymm.root.tictactoe2.MainActivity

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

class TwoPlayersMenuMenu : DisplayMenu() {

    override fun initFragmentObjects(activity: AppCompatActivity) {
        headerFrg = TwoPlayersHeaderFragment()
        buttonsFrg = TwoPlayersButtonsFragment()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}

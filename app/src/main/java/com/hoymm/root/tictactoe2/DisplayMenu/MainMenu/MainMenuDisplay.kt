package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu

import android.support.v7.app.AppCompatActivity

import com.hoymm.root.tictactoe2.DisplayMenu.DisplayMenu

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

class MainMenuDisplay : DisplayMenu() {

    override fun initFragmentObjects(activity: AppCompatActivity) {
        headerFrg = MainMenuTextAndGraphHeaderFragment()
        buttonsFrg = MainMenuButtonsFragment()
    }
}

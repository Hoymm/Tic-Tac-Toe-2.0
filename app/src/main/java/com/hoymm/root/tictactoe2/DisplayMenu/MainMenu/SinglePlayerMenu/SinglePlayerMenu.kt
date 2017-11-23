package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.DifficulyFragment
import com.hoymm.root.tictactoe2.MainActivity
import com.hoymm.root.tictactoe2.R

class SinglePlayerMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.single_player_activity)
        initAndAddFragmentsIfActivityIsFreshlyStarted(savedInstanceState)
    }

    private fun initAndAddFragmentsIfActivityIsFreshlyStarted(savedInstanceState: Bundle?) {
        if (savedInstanceState == null)
            initAndAddFragments()
    }

    private fun initAndAddFragments() {
        addDifficulyFragment()
        addGridsFragments()
    }

    private fun addDifficulyFragment() {
        addNewFragment(R.id.singlePlayerGridDifficulyChooseID, DifficulyFragment())
    }

    private fun addGridsFragments() {
        addNewFragment(R.id.grid7X7ID, GridFragment7x7())
        addNewFragment(R.id.grid5X5ID, GridFragment5x5())
        addNewFragment(R.id.grid3X3ID, GridFragment3x3())
    }

    private fun addNewFragment(ID: Int, fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(ID, fragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
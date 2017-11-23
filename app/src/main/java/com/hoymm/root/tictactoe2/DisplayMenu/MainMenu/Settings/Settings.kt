package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.hoymm.root.tictactoe2.MainActivity
import com.hoymm.root.tictactoe2.R


class Settings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        initAndAddComponentsIfActivityFreshlyStarted(savedInstanceState)
    }

    private fun initAndAddComponentsIfActivityFreshlyStarted(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            addDifficulyButtonsFragment()
            addEffectsButtonsFragment()
        }
    }

    private fun addDifficulyButtonsFragment() {
        addNewFragment(R.id.settingsDifficulyID, DifficulyFragment())
    }

    private fun addEffectsButtonsFragment() {
        addNewFragment(R.id.settingsEffectsID, EffectsFragment())
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

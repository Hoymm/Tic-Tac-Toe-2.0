package com.hoymm.root.tictactoe2.DisplayMenu

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

import com.hoymm.root.tictactoe2.DisplayMenu.Fragments.ButtonsFragment
import com.hoymm.root.tictactoe2.DisplayMenu.Fragments.HeaderFragment
import com.hoymm.root.tictactoe2.R


/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

abstract class DisplayMenu : AppCompatActivity() {
    private var fragmentTransaction: FragmentTransaction? = null
    protected var headerFrg: HeaderFragment? = null
    protected var buttonsFrg: ButtonsFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        initFragmentObjects(this)
        display()
    }

    protected abstract fun initFragmentObjects(activity: AppCompatActivity)

    private fun display() {
        inflateHeaderFragment(headerFrg)
        inflateButtonsFragment(buttonsFrg)
        fragmentTransaction!!.commit()
    }


    private fun inflateHeaderFragment(headerFragment: HeaderFragment?) {
        fragmentTransaction!!.replace(R.id.mainActivityHeader, headerFragment)
    }

    private fun inflateButtonsFragment(buttonsFragment: ButtonsFragment?) {
        fragmentTransaction!!.replace(R.id.mainActivityButtons, buttonsFragment)
    }
}

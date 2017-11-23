package com.hoymm.root.tictactoe2.GameEngine

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.DifficultyEnum
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.SettingsSharedPreferences
import com.hoymm.root.tictactoe2.MainActivity
import com.hoymm.root.tictactoe2.R

import java.util.Random

/**
 * Created by Damian Muca - Kaizen (26.09.17)
 */

abstract class GameEngine : AppCompatActivity(), GameFragsCommunication {

    companion object {
        val GAME_BOARD_SIZE_KEY = "com.hoymm.root.tictactoe2.GameEngine.GAME_BOARD_SIZE_KEY"
        val GAME_HARDNESS_KEY = "com.hoymm.root.tictactoe2.GameEngine.GAME_HARDNESS_KEY"
    }

    private var nowIsCircleTurn: Boolean = false
    private var youAreACircle: Boolean = false

    private lateinit var headerFragment: GameHeaderFragment
    private lateinit var boardFragment: GameBoardFragment
    private lateinit var footerFragment: GameFooterFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)
        drawWhoStartsAndWhatSymbolPlays()
        initAndAddFragments()
    }

    private fun drawWhoStartsAndWhatSymbolPlays() {
        val randomNumber0or1 = Random().nextInt() % 2
        nowIsCircleTurn = randomNumber0or1 == 0
        youAreACircle = randomNumber0or1 == 0
    }

    private fun initAndAddFragments() {
        initAndAddHeaderFragment()
        initAndAddBoardFragment()
        initAndAddFooterFragment()
    }

    private fun initAndAddHeaderFragment() {
        headerFragment = GameHeaderFragment()
        addNewFragment(R.id.gameHeader, headerFragment)
    }

    private fun initAndAddBoardFragment() {
        initBoardFragment()
        addNewFragment(R.id.gameBoardFragment, boardFragment)
    }

    private fun initBoardFragment() {
        boardFragment = GameBoardFragment()
        boardFragment.arguments = intent.extras
    }

    private fun initAndAddFooterFragment() {
        footerFragment = GameFooterFragment()
        footerFragment.arguments = dataToBeSendToFooterFragment()
        addNewFragment(R.id.gameFooter, footerFragment)
    }

    private fun dataToBeSendToFooterFragment(): Bundle {
        val bundleData = Bundle()
        val idOfDifficulyEnabled = SettingsSharedPreferences.getDifficultyId(applicationContext)
        val difficultyEnum = DifficultyEnum.getDifficultyFromID(idOfDifficulyEnabled)
        bundleData.putSerializable(GameFooterFragment.HARDNESS_KEY, difficultyEnum)
        return bundleData
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

    override fun getWhosTurnNow(): String =
            if (nowIsCircleTurn) getString(R.string.circle) else getString(R.string.cross)

    override fun isCircleTurnNow(): Boolean = nowIsCircleTurn

    override fun isYourTurnNow(): Boolean = youAreACircle && nowIsCircleTurn
}

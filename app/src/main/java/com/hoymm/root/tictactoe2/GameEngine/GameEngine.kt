package com.hoymm.root.tictactoe2.GameEngine

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.DifficultyEnum
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.SettingsSharedPreferences
import com.hoymm.root.tictactoe2.GameEngine.EnumClasses.Shape
import com.hoymm.root.tictactoe2.GameEngine.CommunicationInterfaces.CheckIsGameFinished
import com.hoymm.root.tictactoe2.GameEngine.CommunicationInterfaces.CurAppData
import com.hoymm.root.tictactoe2.GameEngine.CommunicationInterfaces.GameFragsCommunication
import com.hoymm.root.tictactoe2.GameEngine.GameActivityFragments.GameBoardFragment
import com.hoymm.root.tictactoe2.GameEngine.GameActivityFragments.GameFooterFragment
import com.hoymm.root.tictactoe2.GameEngine.GameActivityFragments.GameHeaderFragment
import com.hoymm.root.tictactoe2.MainActivity
import com.hoymm.root.tictactoe2.R

import java.util.Random

/**
 * Created by Damian Muca - Kaizen (26.09.17)
 */

abstract class GameEngine : AppCompatActivity(), CurAppData, CheckIsGameFinished, GameFragsCommunication {
    companion object {
        val GAME_BOARD_SIZE_KEY = "com.hoymm.root.tictactoe2.GameEngine.GAME_BOARD_SIZE_KEY"
        val GAME_HARDNESS_KEY = "com.hoymm.root.tictactoe2.GameEngine.GAME_HARDNESS_KEY"
    }

    private var whoseTurnNow = Shape.circle
    private var youAreACircle = false

    private lateinit var headerFragment: GameHeaderFragment
    private lateinit var gameFragment: GameBoardFragment
    private lateinit var footerFragment: GameFooterFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)
        drawWhoStartsAndWhatSymbolPlays()
        initAndAddFragments()
    }

    private fun drawWhoStartsAndWhatSymbolPlays() {
        val randomNumber0or1 = Random().nextInt() % 2
        whoseTurnNow = if (randomNumber0or1 == 0) Shape.circle else Shape.cross
        youAreACircle = randomNumber0or1 == 0
    }

    private fun initAndAddFragments() {
        createHeaderFrag()
        createGameFrag()
        createFooterFrag()
    }

    private fun createHeaderFrag() {
        headerFragment = GameHeaderFragment()
        addNewFragment(R.id.gameHeader, headerFragment)
    }

    private fun createGameFrag() {
        gameFragment = GameBoardFragment()
        gameFragment.arguments = intent.extras
        addNewFragment(R.id.gameBoardFragment, gameFragment)
    }

    private fun createFooterFrag() {
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

    override val getWhoseTurnNow: Shape get() = whoseTurnNow

    override val isYourTurnNow: Boolean
        get() = youAreACircle && this.whoseTurnNow == Shape.circle

    override fun changePlayerTurn() {
        this.whoseTurnNow = if (whoseTurnNow == Shape.circle) Shape.cross else Shape.circle
        headerFragment.changeTurnToOpposiveTextView()
    }

    override fun checkIfSomeoneWon(): Shape? = gameFragment.checkIfSomeoneWon()

    override fun checkIfItIsADraw(): Boolean = gameFragment.checkIfItIsADraw()

    override fun changeTurnOnOpposive() {
        headerFragment.changeTurnToOpposiveTextView()
    }

    override fun showSettingsInGameFragment() {
        gameFragment.showSettingsFragment()
    }
}

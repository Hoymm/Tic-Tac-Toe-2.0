package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.DifficultyEnum
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.SettingsSharedPreferences
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu.SinglePlayerGame.SinglePlayerGame
import com.hoymm.root.tictactoe2.GameEngine.GameEngine
import com.hoymm.root.tictactoe2.R

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

internal abstract class GridFragment : Fragment() {
    protected lateinit var gridModeTextView: TextView
    protected lateinit var gridImage: ImageView
    protected lateinit var entireFragmentArea: LinearLayout


    private val listenerForOnFragmentClick: View.OnClickListener
        get() = View.OnClickListener { onFragmentClickBehavior() }

    override fun onCreateView
            (inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View
            = inflater!!.inflate(R.layout.menu_choose_grid_fragment, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linkXMLObjects()
        initXMLObjectsAndSetText()
        setOnFragmentClickBehavior()
    }

    private fun linkXMLObjects() {
        gridModeTextView = activity.findViewById(R.id.chooseGridAmountText)
        gridImage = activity.findViewById(R.id.chooseGridImageView)
        entireFragmentArea = activity.findViewById(R.id.gridFragmentChooseLinearLayoutId)
    }

    private fun setOnFragmentClickBehavior() {
        entireFragmentArea.setOnClickListener(listenerForOnFragmentClick)
    }

    fun onFragmentClickBehavior() {
        var newGame = Intent(context, SinglePlayerGame::class.java)
        newGame = sendDifficultyInfoToGame(newGame)
        newGame = sendBoardSizeDataInfoToGame(newGame)
        startActivity(newGame)
        activity.finish()
    }

    fun sendDifficultyInfoToGame(newGameIntent: Intent): Intent {
        val idOfDifficulyEnabled = SettingsSharedPreferences.getDifficultyId(activity)
        newGameIntent.putExtra(GameEngine.GAME_HARDNESS_KEY, DifficultyEnum.getDifficultyFromID(idOfDifficulyEnabled))
        return newGameIntent
    }

    internal abstract fun sendBoardSizeDataInfoToGame(newGameIntent: Intent): Intent
    internal abstract fun initXMLObjectsAndSetText()
}

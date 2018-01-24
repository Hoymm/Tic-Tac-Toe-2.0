package com.hoymm.root.tictactoe2.GameEngine.GameActivityFragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.DifficultyEnum
import com.hoymm.root.tictactoe2.GameEngine.CommunicationInterfaces.GameFragsCommunication
import com.hoymm.root.tictactoe2.MainActivity
import com.hoymm.root.tictactoe2.R

/**
 * Created by hoymm on 01.11.17
 */

class GameFooterFragment : Fragment() {
    private lateinit var gameFragsCommunication: GameFragsCommunication

    private var exitButton: Button? = null
    private var hardnessDisplayTextView: TextView? = null
    private var gameDifficulty: String? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        loadDataThatHasBeenSentToAFragment()
        return inflater!!.inflate(R.layout.game_footer, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initXMLObjects()
        setProperHardnessLevelText()
        setExitButtonAction()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        gameFragsCommunication = context as GameFragsCommunication
    }

    private fun loadDataThatHasBeenSentToAFragment() {
        loadDifficultyData()
    }

    private fun loadDifficultyData() {
        val difficultyEnum = arguments.getSerializable(HARDNESS_KEY) as DifficultyEnum
        gameDifficulty = when (difficultyEnum) {
            DifficultyEnum.easy -> getString(R.string.easy)
            DifficultyEnum.medium -> getString(R.string.medium)
            DifficultyEnum.hard -> getString(R.string.hard)
        }
    }

    private fun initXMLObjects() {
        exitButton = activity.findViewById(R.id.exitGameButtonId)
        hardnessDisplayTextView = activity.findViewById(R.id.hardnessDisplayTextId)
    }

    private fun setProperHardnessLevelText() {
        hardnessDisplayTextView!!.text = gameDifficulty
    }

    private fun setExitButtonAction() {
        exitButton!!.setOnClickListener {
            startActivity(Intent(context, MainActivity::class.java))
            activity.finish()
        }
    }

    companion object {
        internal val HARDNESS_KEY = "com.hoymm.root.tictactoe2.GameEngine.HARDNESS_KEY"
    }
}

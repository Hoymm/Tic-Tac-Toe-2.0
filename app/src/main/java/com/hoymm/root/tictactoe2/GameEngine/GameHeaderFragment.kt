package com.hoymm.root.tictactoe2.GameEngine

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.hoymm.root.tictactoe2.R

/**
 * Created by Damian Muca - Kaizen (26.09.17)
 */

internal class GameHeaderFragment : Fragment() {
    private var circleTV: TextView? = null
    private var crossTV: TextView? = null
    private var drawsTV: TextView? = null
    private var whosTurnTV: TextView? = null
    private var circleScores = 0
    private var crossScores = 0
    private var drawsScores = 0
    private var gameFragsCommunication: CurrentAppDataInfo? = null

    private val whosTurnTextColor: Int get() =
            if (gameFragsCommunication!!.isCircleTurnNow) ContextCompat.getColor(context, R.color.circleBlue)
            else ContextCompat.getColor(context, R.color.crossRed)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.game_header, container, false)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            gameFragsCommunication = context as CurrentAppDataInfo
        } catch (e: ClassCastException) {
            throw ClassCastException(context!!.toString() + " must implement OnFragmentSendText")
        }

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        initTextViews()
        drawRandomMovementOrder()
        setValuesForComponents()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initTextViews() {
        circleTV = activity.findViewById(R.id.circleScoreAmountID)
        crossTV = activity.findViewById(R.id.crossScoresAmountID)
        drawsTV = activity.findViewById(R.id.drawsScoresAmountID)
        whosTurnTV = activity.findViewById(R.id.turnValueID)
    }

    private fun drawRandomMovementOrder() {

    }

    private fun setValuesForComponents() {
        circleTV!!.text = circleScores.toString()
        crossTV!!.text = crossScores.toString()
        drawsTV!!.text = drawsScores.toString()

        changeWhosTurnNowTextView()
    }

    fun changeWhosTurnNowTextView() {
        whosTurnTV!!.text = gameFragsCommunication!!.whosTurnNow // TODO here is some error because turn circle and it shows cross and reverse
        whosTurnTV!!.setTextColor(whosTurnTextColor)
    }

    fun increaseCircleScores() {
        circleTV!!.setText(++circleScores)
    }

    fun increaseCrossScores() {
        crossTV!!.setText(++crossScores)
    }

    fun increaseDrawsScores() {
        drawsTV!!.setText(++drawsScores)
    }
}

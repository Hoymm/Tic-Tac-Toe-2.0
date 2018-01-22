package com.hoymm.root.tictactoe2.GameEngine

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.hoymm.root.tictactoe2.R

/**
 * Created by Damian Muca - Kaizen (26.09.17)
 */

internal class GameHeaderFragment : Fragment() {
    private lateinit var whosTurnTV: TextView
    private var gameFragsCommunication: CurAppData? = null
    private lateinit var settingsIcon: ImageView

    private val whosTurnTextColor: Int get() =
            if (gameFragsCommunication!!.getWhoseTurnNow == Shape.circle)
                ContextCompat.getColor(context, R.color.circleBlue)
            else ContextCompat.getColor(context, R.color.crossRed)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.game_header, container, false)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            gameFragsCommunication = context as CurAppData
        } catch (e: ClassCastException) {
            throw ClassCastException(context!!.toString() + " must implement OnFragmentSendText")
        }

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        initTextViews()
        drawRandomMovementOrder()
        setActionForSettingsButton()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initTextViews() {
        whosTurnTV = activity.findViewById(R.id.turnValueID)
        settingsIcon = activity.findViewById(R.id.settingsIcon)
    }

    private fun drawRandomMovementOrder() {

    }

    private fun setActionForSettingsButton(){
        settingsIcon.setOnClickListener{
            Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show()
        }
    }

    fun changeTurnToOpposiveTextView() {
        whosTurnTV.text = gameFragsCommunication!!.getWhoseTurnNow.toString()
        whosTurnTV.setTextColor(whosTurnTextColor)
    }

}

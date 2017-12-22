package com.hoymm.root.tictactoe2.GameEngine

import android.content.Context
import com.airbnb.lottie.LottieAnimationView

/**
 * Created by Damian Muca (Kaizen) on 21.12.17.
 */
class GameField(context: Context) : LottieAnimationView(context) {
    private var alreadyOccupied: Boolean = false

    fun isOccupied() = alreadyOccupied

    fun setOccupied(state: Boolean) {
        alreadyOccupied = state
    }
}
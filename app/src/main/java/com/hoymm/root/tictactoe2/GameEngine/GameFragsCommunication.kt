package com.hoymm.root.tictactoe2.GameEngine

/**
 * Created by hoymm on 10.11.17.
 */

interface GameFragsCommunication {
    val whosTurnNow: String
    val isCircleTurnNow: Boolean
    val isYourTurnNow: Boolean
}

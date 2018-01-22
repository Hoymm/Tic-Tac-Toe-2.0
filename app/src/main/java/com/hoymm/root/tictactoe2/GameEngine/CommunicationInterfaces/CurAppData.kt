package com.hoymm.root.tictactoe2.GameEngine.CommunicationInterfaces

import com.hoymm.root.tictactoe2.GameEngine.EnumClasses.Shape

/**
 * Created by Damian Muca (Kaizen) on 22.12.17.
 */
interface CurAppData {
    val getWhoseTurnNow: Shape
    val isYourTurnNow: Boolean
    fun changePlayerTurn()
}
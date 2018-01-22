package com.hoymm.root.tictactoe2.GameEngine.CommunicationInterfaces

import com.hoymm.root.tictactoe2.GameEngine.EnumClasses.Shape

/**
 * Created by Damian Muca (Kaizen) on 22.12.17.
 */
interface CheckIsGameFinished {
    fun checkIfSomeoneWon() : Shape?
    fun checkIfItIsADraw() : Boolean
}
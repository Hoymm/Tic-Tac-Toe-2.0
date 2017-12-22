package com.hoymm.root.tictactoe2.GameEngine

/**
 * Created by Damian Muca (Kaizen) on 22.12.17.
 */
interface ChangeAppState {
    fun changePlayerTurn()
    fun checkIfSomeoneWon() : Shape?
}
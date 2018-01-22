package com.hoymm.root.tictactoe2.GameEngine

import android.util.Log
import android.widget.GridView
import com.hoymm.root.tictactoe2.GameEngine.EnumClasses.Shape

/**
 * Created by Damian Muca (Kaizen) on 23.12.17.
 */

class CheckWin(private var gameBoard: GridView){

    private enum class Table {
        Column, Row
    }

    fun checkIfWinInRows(howManyPointsWin: Int): Shape?{
        Log.i("CheckWin", "checkIfWinInRows")
        return checkIfAnyRowOrColumnWins(howManyPointsWin, Table.Row)
    }

    fun checkIfWinInColumns(howManyPointsWin : Int): Shape?{
        Log.i("CheckWin", "checkIfWinInColumns")
        return checkIfAnyRowOrColumnWins(howManyPointsWin, Table.Column)
    }

    private fun checkIfAnyRowOrColumnWins(howManyPointsWin: Int, checkingDirection : Table): Shape? {
        for (row in 0 until gameBoard.numColumns) {
            var lastShape: Shape? = null
            var howManyPoints = 0
            for (column in 0 until gameBoard.numColumns) {
                val curField = when (checkingDirection){
                    Table.Column -> gameBoard.getChildAt(row + column* gameBoard.numColumns) as GameField
                    Table.Row -> gameBoard.getChildAt(row* gameBoard.numColumns + column) as GameField
                }
                val curShape = curField.whatShape()

                howManyPoints = when {
                    curShape == null -> 0
                    lastShape != curShape -> 1
                    else -> howManyPoints + 1
                }
                lastShape = curShape

                if (howManyPoints == howManyPointsWin)
                    return curShape
            }
        }
        return null
    }

    fun checkIfWinDiagonalFromTopRow(howManyPointsWin : Int): Shape?{
        Log.i("CheckWin", "checkIfWinDiagonalFromTopRow")
        return checkDiagonalTopRowToRight(howManyPointsWin) ?: checkDiagonalTopRowToLeft(howManyPointsWin)
    }

    fun checkIfWinDiagonalLeftColumnToBottom(howManyPointsWin: Int): Shape?{
        Log.i("CheckWin", "checkIfWinDiagonalLeftColumnToBottom")
        return checkDiagonal(howManyPointsWin, gameBoard.numColumns, gameBoard.numColumns+1)
    }

    private fun checkDiagonalTopRowToRight(howManyPointsWin : Int): Shape? {
        Log.i("CheckWin", "checkDiagonalTopRowToRight")
        return checkDiagonal(howManyPointsWin, 1, gameBoard.numColumns+1)
    }

    private fun checkDiagonalTopRowToLeft(howManyPointsWin : Int): Shape?{
        Log.i("CheckWin", "checkDiagonalTopRowToLeft")
        return checkDiagonal(howManyPointsWin, 1, gameBoard.numColumns-1)
    }

    private fun checkDiagonal(howManyPointsWin: Int, multipler: Int, stepMove: Int): Shape? {
        for (row in 0 until gameBoard.numColumns) {
            var lastShape: Shape? = null
            var howManyPoints = 0
            var lastFieldIndex = -1
            for (fieldIndex in row*multipler until gameBoard.numColumns * gameBoard.numColumns step stepMove) {
                if (!isDiagonalInNextOrPreviousLine(lastFieldIndex, fieldIndex))
                    break

                val curField = gameBoard.getChildAt(fieldIndex) as GameField
                val curShape = curField.whatShape()

                howManyPoints = when {
                    curShape == null -> 0
                    lastShape != curShape -> 1
                    else -> howManyPoints + 1
                }
                lastShape = curShape
                lastFieldIndex = fieldIndex

                if (howManyPoints == howManyPointsWin)
                    return curShape
            }
        }
        return null
    }

    private fun isDiagonalInNextOrPreviousLine(lastFieldIndex: Int, fieldIndex: Int) =
            Math.abs(lastFieldIndex / gameBoard.numColumns - fieldIndex / gameBoard.numColumns) == 1
}

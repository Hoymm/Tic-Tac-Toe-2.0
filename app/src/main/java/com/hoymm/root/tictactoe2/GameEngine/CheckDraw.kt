package com.hoymm.root.tictactoe2.GameEngine

import android.util.Log
import android.widget.GridView


/**
 * Created by Damian Muca (Kaizen) on 23.12.17.
 */
class CheckDraw(private var gameBoard: GridView) {

    private enum class Table {
        Column, Row
    }

    fun checkIfDrawInRows(howManyPointsWin: Int): Boolean = checkIfAnyRowOrColumnDraws(howManyPointsWin, Table.Row)

    fun checkIfDrawInColumns(howManyPointsWin : Int): Boolean = checkIfAnyRowOrColumnDraws(howManyPointsWin, Table.Column)

    private fun checkIfAnyRowOrColumnDraws(howManyPointsWin: Int, checkingDirection : Table): Boolean {
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
                    lastShape != null && curShape != null && curShape != lastShape -> 1
                    else -> howManyPoints + 1
                }
                lastShape = curShape

                if (howManyPoints == howManyPointsWin)
                    return false
            }
        }
        return true
    }

    fun checkIfDrawDiagonalFromTopRow(howManyPointsWin : Int) =
        checkDiagonalTopRowToRight(howManyPointsWin) && checkDiagonalTopRowToLeft(howManyPointsWin)

    fun checkIfDrawDiagonalLeftColumnToBottom(howManyPointsWin: Int) =
            checkDiagonal(howManyPointsWin, gameBoard.numColumns, gameBoard.numColumns+1)

    private fun checkDiagonalTopRowToRight(howManyPointsWin : Int) = checkDiagonal(howManyPointsWin, 1, gameBoard.numColumns+1)

    private fun checkDiagonalTopRowToLeft(howManyPointsWin : Int) = checkDiagonal(howManyPointsWin, 1, gameBoard.numColumns-1)

    private fun checkDiagonal(howManyPointsWin: Int, multipler: Int, stepMove: Int): Boolean {
        for (row in 0 until gameBoard.numColumns) {
            var lastShape: Shape? = null
            var howManyPoints = 0
            for (fieldIndex in row*multipler until gameBoard.numColumns * gameBoard.numColumns step stepMove) {
                val curField = gameBoard.getChildAt(fieldIndex) as GameField
                val curShape = curField.whatShape()

                howManyPoints = when {
                    lastShape != null && curShape != null && curShape != lastShape -> 1
                    else -> howManyPoints + 1
                }
                lastShape = curShape
                Log.i("PointsFor", lastShape.toString() + ": " + howManyPoints);

                if (howManyPoints == howManyPointsWin)
                    return false
            }
        }
        return true
    }

}
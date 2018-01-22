package com.hoymm.root.tictactoe2.GameEngine

import android.util.Log
import android.widget.GridView
import com.hoymm.root.tictactoe2.GameEngine.EnumClasses.Shape


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
            var circlePoints = 0
            var crossPoints = 0
            for (column in 0 until gameBoard.numColumns) {
                val curField = when (checkingDirection){
                    Table.Column -> gameBoard.getChildAt(row + column*gameBoard.numColumns) as GameField
                    Table.Row -> gameBoard.getChildAt(row*gameBoard.numColumns + column) as GameField
                }
                val curShape = curField.whatShape()

                when (curShape) {
                    null -> {
                        circlePoints++
                        crossPoints++
                    }
                    Shape.circle -> {
                        crossPoints = 0
                        circlePoints++
                    }
                    Shape.cross -> {
                        circlePoints = 0
                        crossPoints++
                    }
                }

                Log.i("PointsFor", "Circle == $circlePoints, Cross == $crossPoints")

                if (circlePoints == howManyPointsWin || crossPoints == howManyPointsWin) {
                    Log.i("PointsFor", "FALSE")
                    return false
                }
            }
        }
        Log.i("PointsFor", "TRUE")
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
            var circlePoints = 0
            var crossPoints = 0
            var lastFieldIndex = -1
            for (fieldIndex in row*multipler until gameBoard.numColumns * gameBoard.numColumns step stepMove) {
                if (!isDiagonalInNextOrPreviousLine(lastFieldIndex, fieldIndex))
                    break

                val curField = gameBoard.getChildAt(fieldIndex) as GameField
                val curShape = curField.whatShape()


                when (curShape) {
                    null -> {
                        circlePoints++
                        crossPoints++
                    }
                    Shape.circle -> {
                        crossPoints = 0
                        circlePoints++
                    }
                    Shape.cross -> {
                        circlePoints = 0
                        crossPoints++
                    }
                }
                lastFieldIndex = fieldIndex

                if (circlePoints == howManyPointsWin || crossPoints == howManyPointsWin) {
                    Log.i("PointsFor", "FALSE")
                    return false
                }
            }
        }
        return true
    }

    private fun isDiagonalInNextOrPreviousLine(lastFieldIndex: Int, fieldIndex: Int) =
            Math.abs(lastFieldIndex / gameBoard.numColumns - fieldIndex / gameBoard.numColumns) == 1

}
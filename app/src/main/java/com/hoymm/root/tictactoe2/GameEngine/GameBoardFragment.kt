package com.hoymm.root.tictactoe2.GameEngine

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.GridView
import android.widget.LinearLayout
import com.hoymm.root.tictactoe2.R
import java.lang.ClassCastException

class GameBoardFragment : Fragment(), CheckIsGameFinished {
    private lateinit var gameBoard: GridView
    private var boardSize: BoardSize? = null
    private var fieldLength : Int = 0
    private var fieldsSeparatorLength: Int = 0
    private lateinit var currentAppDataInfo : CurrentAppDataInfo

    private val howManyFieldsInRow: Int get() =
       when (boardSize) {
            BoardSize.board3x3 -> 3
            BoardSize.board5x5 -> 5
            BoardSize.board7x7 -> 7
            else -> 3
        }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try{
            currentAppDataInfo = context as CurrentAppDataInfo
        }
        catch (exception : ClassCastException){
            throw ClassCastException(activity.toString() + " must implement CurrentAppDataInfo");
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater!!.inflate(R.layout.game_board_fragment, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        boardSize = arguments.get(GameEngine.GAME_BOARD_SIZE_KEY) as BoardSize

        view!!.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                getView()!!.viewTreeObserver.removeOnGlobalLayoutListener(this)
                generateGameBoard()
            }
        })
    }

    private fun generateGameBoard() {
        gameBoard = activity.findViewById<GridView>(R.id.game_board_fragment_id)
        calculateFieldAndSeparatorLength()
        setNewWidthAndHeightForGameBoardView(gameBoard)
        setAdapter(gameBoard)
        setNumOfColumnsAndSpacingGridViewShouldHave(gameBoard)
    }

    private fun calculateFieldAndSeparatorLength() {
        val parentLayoutShorterSideLength =  Math.min(getParentLinearLayout().height, getParentLinearLayout().width)
        fieldsSeparatorLength = parentLayoutShorterSideLength/((Math.sqrt(howManyFieldsInRow.toDouble())*50).toInt())
        fieldLength = getTotalLengthOfFieldsInRow(parentLayoutShorterSideLength)/howManyFieldsInRow
    }

    private fun setNewWidthAndHeightForGameBoardView(gameBoardGridView: GridView) {
        val gameBoardSideLength = getTotalLengthOfSeparatorsInRow() + fieldLength * howManyFieldsInRow
        gameBoardGridView.layoutParams.width = gameBoardSideLength
        gameBoardGridView.layoutParams.height = gameBoardSideLength
    }

    private fun setAdapter(gameBoardLayout: GridView) {
        gameBoardLayout.adapter = GameBoardAdapter(activity, howManyFieldsInRow, fieldLength)
    }

    private fun setNumOfColumnsAndSpacingGridViewShouldHave(gameBoardLayout: GridView) {
        gameBoardLayout.numColumns = howManyFieldsInRow
        gameBoardLayout.horizontalSpacing = fieldsSeparatorLength
        gameBoardLayout.verticalSpacing = fieldsSeparatorLength
    }

    private fun getParentLinearLayout() =
            activity.findViewById<LinearLayout>(R.id.game_board_background_layout)

    private fun getTotalLengthOfFieldsInRow(shorterParentSideLength: Int) =
            shorterParentSideLength - getTotalLengthOfSeparatorsInRow()

    private fun getTotalLengthOfSeparatorsInRow() =
            howManyFieldSeparatorsInRow() * fieldsSeparatorLength

    private fun howManyFieldSeparatorsInRow() = (howManyFieldsInRow - 1)

    override fun checkIfSomeoneWon(): Shape? {
        var whoWon: Shape?
        val winCheck = CheckWin(gameBoard)

        whoWon = winCheck.checkIfWinInRows(getHowManyPointsWins())
        if (whoWon != null) return whoWon

        whoWon = winCheck.checkIfWinInColumns(getHowManyPointsWins())
        if (whoWon != null) return whoWon

        whoWon = winCheck.checkIfWinDiagonalFromTopRow(getHowManyPointsWins())
        if (whoWon != null) return whoWon

        whoWon = winCheck.checkIfWinDiagonalLeftColumnToBottom(getHowManyPointsWins())
        if (whoWon != null) return whoWon

        return null
    }

    override fun checkIfItIsADraw(): Boolean {
        var isItADraw: Boolean?
        val drawCheck = CheckDraw(gameBoard)

        isItADraw = drawCheck.checkIfDrawInRows(getHowManyPointsWins())
        if (isItADraw == false) return false

        isItADraw = drawCheck.checkIfDrawInColumns(getHowManyPointsWins())
        if (isItADraw == false) return false

        isItADraw = drawCheck.checkIfDrawDiagonalFromTopRow(getHowManyPointsWins())
        if (isItADraw == false) return false

        isItADraw = drawCheck.checkIfDrawDiagonalLeftColumnToBottom(getHowManyPointsWins())
        if (isItADraw == false) return false

        return true
    }

    private fun getHowManyPointsWins() = if (boardSize == BoardSize.board3x3) 3 else 4
}

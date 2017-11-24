package com.hoymm.root.tictactoe2.GameEngine

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*
import android.widget.GridView
import android.widget.LinearLayout
import com.hoymm.root.tictactoe2.R
import android.widget.Toast

/**
 * Created by hoymm on 03.11.17.
 */

class GameBoardFragment : Fragment() {

    private var boardSize: BoardSize? = null

    private val howManyFieldsInRow: Int get() =
       when (boardSize) {
            BoardSize.board3x3 -> 3
            BoardSize.board5x5 -> 5
            BoardSize.board7x7 -> 7
            else -> 3
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
        val gameBoardLayout = activity.findViewById<GridView>(R.id.game_board_fragment_id)

        scaleGameBoardToSquareSize(gameBoardLayout)

        gameBoardLayout.numColumns = howManyFieldsInRow

        val howManyFieldsInRow = howManyFieldsInRow
        var boardLength = Math.min(gameBoardLayout.width, gameBoardLayout.height)
        boardLength -= gameBoardLayout.paddingLeft + gameBoardLayout.paddingRight

        gameBoardLayout.adapter = GameBoardAdapter(context, howManyFieldsInRow)

        gameBoardLayout.horizontalSpacing = gameBoardLayout.width/GameBoardAdapter.separateLineDivider
        gameBoardLayout.verticalSpacing = gameBoardLayout.width/GameBoardAdapter.separateLineDivider
        Log.i("Spacing", "ver: " + gameBoardLayout.verticalSpacing + ", horizontal: " + gameBoardLayout.horizontalSpacing)
        Log.i("Spacing", "width: " + gameBoardLayout.width + ", height: " + gameBoardLayout.height)

        gameBoardLayout.setOnItemClickListener(
                { parent, v, position, id ->
                Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show()
            })

    }

    private fun scaleGameBoardToSquareSize(gameBoardLayout: GridView) {
        var backgroundLayout = activity.findViewById<LinearLayout>(R.id.game_board_background_layout)
        val boardParams = gameBoardLayout.layoutParams
        boardParams.height = Math.min(backgroundLayout.height, backgroundLayout.width)/* - gameBoardLayout.width/25*(howManyFieldsInRow-1)*/
        boardParams.width = Math.min(backgroundLayout.height, backgroundLayout.width)
        gameBoardLayout.layoutParams = boardParams
    }
}

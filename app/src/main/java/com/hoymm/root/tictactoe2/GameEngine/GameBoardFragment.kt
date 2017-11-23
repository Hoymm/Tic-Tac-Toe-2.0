package com.hoymm.root.tictactoe2.GameEngine

import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.ImageView
import android.widget.LinearLayout

import com.airbnb.lottie.LottieAnimationView
import com.hoymm.root.tictactoe2.R

/**
 * Created by hoymm on 03.11.17.
 */

class GameBoardFragment : Fragment() {
    companion object {
        private val fieldMargin = dpToPx(10)
        private val fieldPadding = dpToPx(10)

        fun dpToPx(dp: Int): Float = dp * Resources.getSystem().displayMetrics.density
    }

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
        val gameBoardLayout = activity.findViewById<LinearLayout>(R.id.game_board_fragment_id)
        val howManyFieldsInRow = howManyFieldsInRow

        var boardLength = Math.min(gameBoardLayout.width, gameBoardLayout.height)
        boardLength -= gameBoardLayout.paddingLeft + gameBoardLayout.paddingRight

        val gameFieldParameters = GameFieldParameters()
        gameFieldParameters.fieldLength = boardLength / howManyFieldsInRow - fieldMargin

        for (row in 0 until howManyFieldsInRow) {
            val isItBottomRow = row == howManyFieldsInRow - 1
            gameFieldParameters.setMarginsToZero()
            setVerticalMargins(isItBottomRow, gameFieldParameters)
            insertBoardRow(gameBoardLayout, howManyFieldsInRow, gameFieldParameters)
        }
    }

    private fun setVerticalMargins(isItBottomRow: Boolean, gameFieldParameters: GameFieldParameters) {
        gameFieldParameters.marginBottom = fieldMargin
        if (isItBottomRow)
            gameFieldParameters.marginBottom = 0f
    }

    private inner class GameFieldParameters {
        internal var fieldLength: Float = 0f
        internal var marginLeft: Float = 0f
        internal var marginTop: Float = 0f
        internal var marginRight: Float = 0f
        internal var marginBottom: Float = 0f

        internal fun setMarginsToZero() {
            marginBottom = 0f
            marginRight = marginBottom
            marginTop = marginRight
            marginLeft = marginTop
        }
    }

    private fun insertBoardRow(generalLinearLayout: LinearLayout, howManyFieldsInRow: Int, gameFieldParameters: GameFieldParameters) {
        val rowLinearLayout = createRowLinearLayout(gameFieldParameters)
        generalLinearLayout.addView(rowLinearLayout)
        addGameFieldsToFillRow(rowLinearLayout, howManyFieldsInRow, gameFieldParameters)
    }

    private fun createRowLinearLayout(gameFieldParameters: GameFieldParameters): LinearLayout {
        val rowLinearLayout = LinearLayout(context)
        val rowParams =
                LinearLayout.LayoutParams(
                        (gameFieldParameters.fieldLength * howManyFieldsInRow + (howManyFieldsInRow - 1) * fieldMargin).toInt()
                        , gameFieldParameters.fieldLength.toInt())
        rowLinearLayout.layoutParams = rowParams
        rowLinearLayout.gravity = Gravity.CENTER
        rowLinearLayout.orientation = LinearLayout.HORIZONTAL
        rowLinearLayout.setBackgroundColor(Color.RED)
        return rowLinearLayout
    }

    private fun addGameFieldsToFillRow(rowLinearLayout: LinearLayout, howManyFieldsInRow: Int, gameFieldParameters: GameFieldParameters) {
        for (fieldIndex in 0 until howManyFieldsInRow) {
            val isItLastRightField = fieldIndex == howManyFieldsInRow - 1
            setHorizontalMargins(isItLastRightField, gameFieldParameters)
            rowLinearLayout.addView(createNewBoardField(gameFieldParameters))
        }
    }

    private fun setHorizontalMargins(isItLastField: Boolean, gameFieldParameters: GameFieldParameters) {
        gameFieldParameters.marginRight = fieldMargin
        if (isItLastField)
            gameFieldParameters.marginRight = 0f
    }

    private fun createNewBoardField(gameFieldParameters: GameFieldParameters): LottieAnimationView {
        val myLottieAnimationView = LottieAnimationView(context)

        val fieldParams = LinearLayout.LayoutParams(
                gameFieldParameters.fieldLength.toInt()
                , gameFieldParameters.fieldLength.toInt())
        fieldParams.leftMargin = gameFieldParameters.marginLeft.toInt()
        fieldParams.topMargin = gameFieldParameters.marginTop.toInt()
        fieldParams.rightMargin = gameFieldParameters.marginRight.toInt()
        fieldParams.bottomMargin = gameFieldParameters.marginBottom.toInt()

        myLottieAnimationView.layoutParams = fieldParams
        myLottieAnimationView.setPadding(fieldPadding.toInt(), fieldPadding.toInt(), fieldPadding.toInt(), fieldPadding.toInt())
        //myLottieAnimationView.setAdjustViewBounds(true);
        myLottieAnimationView.scaleType = ImageView.ScaleType.CENTER_CROP
        myLottieAnimationView.setBackgroundColor(ContextCompat.getColor(context, R.color.appBackground))


        myLottieAnimationView.setOnClickListener { v ->
            (v as LottieAnimationView).setAnimation("cross.json")
            v.playAnimation()
        }

        return myLottieAnimationView
    }

    fun setCircleTurnNow() {

    }
}

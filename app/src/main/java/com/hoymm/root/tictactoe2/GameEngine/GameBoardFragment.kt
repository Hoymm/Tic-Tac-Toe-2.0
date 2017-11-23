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
    private var boardSize: BoardSize? = null

    private val howManyFieldsInRow: Int get()
    = when (boardSize) {
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
        val generalLinearLayout = activity.findViewById<LinearLayout>(R.id.game_board_fragment_id)

        val howManyFieldsInRow = howManyFieldsInRow
        var boardLength = Math.min(generalLinearLayout.width, generalLinearLayout.height)
        boardLength -= generalLinearLayout.paddingLeft * 2

        val fieldParameters = FieldParameters()
        fieldParameters.fieldLength = boardLength / howManyFieldsInRow - fieldMargin

        for (row in 0 until howManyFieldsInRow) {
            val isItBottomRow = row == howManyFieldsInRow - 1
            fieldParameters.setMarginsToZero()
            setVerticalMargins(isItBottomRow, fieldParameters)
            insertBoardRow(generalLinearLayout, howManyFieldsInRow, fieldParameters)
        }
    }

    private fun setVerticalMargins(isItBottomRow: Boolean, fieldParameters: FieldParameters) {
        fieldParameters.marginBottom = fieldMargin
        if (isItBottomRow)
            fieldParameters.marginBottom = 0
    }

    private inner class FieldParameters {
        internal var fieldLength: Int = 0
        internal var marginLeft: Int = 0
        internal var marginTop: Int = 0
        internal var marginRight: Int = 0
        internal var marginBottom: Int = 0

        internal fun setMarginsToZero() {
            marginBottom = 0
            marginRight = marginBottom
            marginTop = marginRight
            marginLeft = marginTop
        }
    }

    private fun insertBoardRow(generalLinearLayout: LinearLayout, howManyFieldsInRow: Int, fieldParameters: FieldParameters) {
        val rowLinearLayout = createRowLinearLayout(fieldParameters)
        generalLinearLayout.addView(rowLinearLayout)
        addGameFieldsToFillRow(rowLinearLayout, howManyFieldsInRow, fieldParameters)
    }

    private fun createRowLinearLayout(fieldParameters: FieldParameters): LinearLayout {
        val rowLinearLayout = LinearLayout(context)
        val rowParams = LinearLayout.LayoutParams(fieldParameters.fieldLength * howManyFieldsInRow + (howManyFieldsInRow - 1) * fieldMargin, fieldParameters.fieldLength)
        rowLinearLayout.layoutParams = rowParams
        rowLinearLayout.gravity = Gravity.CENTER
        rowLinearLayout.orientation = LinearLayout.HORIZONTAL
        rowLinearLayout.setBackgroundColor(Color.RED)
        return rowLinearLayout
    }

    private fun addGameFieldsToFillRow(rowLinearLayout: LinearLayout, howManyFieldsInRow: Int, fieldParameters: FieldParameters) {
        for (fieldIndex in 0 until howManyFieldsInRow) {
            val isItLastRightField = fieldIndex == howManyFieldsInRow - 1
            setHorizontalMargins(isItLastRightField, fieldParameters)
            rowLinearLayout.addView(createNewBoardField(fieldParameters))
        }
    }

    private fun setHorizontalMargins(isItLastField: Boolean, fieldParameters: FieldParameters) {
        fieldParameters.marginRight = fieldMargin
        if (isItLastField)
            fieldParameters.marginRight = 0
    }

    private fun createNewBoardField(fieldParameters: FieldParameters): LottieAnimationView {
        val myLottieAnimationView = LottieAnimationView(context)

        val fieldParams = LinearLayout.LayoutParams(
                fieldParameters.fieldLength, fieldParameters.fieldLength)
        fieldParams.leftMargin = fieldParameters.marginLeft
        fieldParams.topMargin = fieldParameters.marginTop
        fieldParams.rightMargin = fieldParameters.marginRight
        fieldParams.bottomMargin = fieldParameters.marginBottom

        myLottieAnimationView.layoutParams = fieldParams
        myLottieAnimationView.setPadding(fieldPadding, fieldPadding, fieldPadding, fieldPadding)
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

    companion object {
        private val fieldMargin = dpToPx(10)
        private val fieldPadding = dpToPx(10)

        fun dpToPx(dp: Int): Int = (dp * Resources.getSystem().displayMetrics.density).toInt()
    }
}

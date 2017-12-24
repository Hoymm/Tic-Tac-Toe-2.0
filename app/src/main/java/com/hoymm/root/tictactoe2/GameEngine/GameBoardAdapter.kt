package com.hoymm.root.tictactoe2.GameEngine

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.hoymm.root.tictactoe2.R

/**
 * Created by hoymm on 23.11.17.
 */

class GameBoardAdapter(private var context: Context, private var howManyFieldsInRow: Int, private var fieldLength: Int) : BaseAdapter(){
    lateinit var CheckIsGameFinished: CheckIsGameFinished
    lateinit var currentAppDataInfo : CurrentAppDataInfo
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?) = createNewBoardField()

    var whoWon: Shape? = null
    var isThereADraw: Boolean = false

    private fun createNewBoardField(): LottieAnimationView {
        val lottieAnimationView = GameField(context)
        CheckIsGameFinished = context as CheckIsGameFinished
        currentAppDataInfo = context as CurrentAppDataInfo

        setWidthAndHeight(lottieAnimationView)
        setPadding(lottieAnimationView)
        setScaleType(lottieAnimationView)
        setBackgroundColor(lottieAnimationView)
        setOnClickListener(lottieAnimationView)

        return lottieAnimationView
    }

    private fun setWidthAndHeight(lottieAnimationView: LottieAnimationView): LottieAnimationView {
        lottieAnimationView.layoutParams = LinearLayout.LayoutParams(fieldLength, fieldLength)
        return lottieAnimationView
    }

    private fun setPadding(lottieAnimationView: LottieAnimationView) {
        val fieldPadding : Int = context.resources.getDimension(R.dimen.game_board_field_padding).toInt() / howManyFieldsInRow
        lottieAnimationView.setPadding(fieldPadding, fieldPadding, fieldPadding, fieldPadding)
    }

    private fun setScaleType(lottieAnimationView: LottieAnimationView) {
        lottieAnimationView.scaleType = ImageView.ScaleType.CENTER_CROP
    }

    private fun setBackgroundColor(lottieAnimationView: LottieAnimationView) {
        lottieAnimationView.setBackgroundColor(ContextCompat.getColor(context, R.color.appBackground))
    }

    private fun setOnClickListener(lottieAnimationView: LottieAnimationView) {
        lottieAnimationView.setOnClickListener { v ->
                getOnClickListenerAction(v)
        }
    }

    private fun getOnClickListenerAction(v: View?){
        if (whoWon != null || isThereADraw) {
            // game already finished
        }
        else if ((v as GameField).whatShape() == null) {
            drawFieldShapeAndChangePlayerTurn(v)
            checkIfAnyoneWonOrDraw()
        } else
            Toast.makeText(context, context.getString(R.string.field_already_occupied_message), Toast.LENGTH_SHORT).show()


    }

    private fun drawFieldShapeAndChangePlayerTurn(v: GameField) {
        setCircleOrCrossAnimation(v)
        v.playAnimation()
        v.setOccupiedBy(currentAppDataInfo.getWhoseTurnNow)
        currentAppDataInfo.changePlayerTurn()
    }

    private fun checkIfAnyoneWonOrDraw() {
        whoWon = CheckIsGameFinished.checkIfSomeoneWon()
        isThereADraw = CheckIsGameFinished.checkIfItIsADraw()

        if (whoWon != null)
            Toast.makeText(context, "$whoWon has won the game.", Toast.LENGTH_SHORT).show()
        else if (isThereADraw){
            Toast.makeText(context, "It is a draw.", Toast.LENGTH_SHORT).show()
        }
    }


    private fun setCircleOrCrossAnimation(v: GameField) {
        if (currentAppDataInfo.getWhoseTurnNow == Shape.circle)
            v.setAnimation("circle.json")
        else
            v.setAnimation("cross.json")
    }

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = howManyFieldsInRow*howManyFieldsInRow
}

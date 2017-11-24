package com.hoymm.root.tictactoe2.GameEngine

import android.content.Context
import android.content.res.Resources
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import com.airbnb.lottie.LottieAnimationView
import com.hoymm.root.tictactoe2.R

/**
 * Created by hoymm on 23.11.17.
 */

class GameBoardAdapter(private var context: Context, private var howManyFieldsInRow: Int, private var fieldLength: Int) : BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?) = createNewBoardField()

    private fun createNewBoardField(): LottieAnimationView {
        val lottieAnimationView = LottieAnimationView(context)

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

    private fun setPadding(lottieAnimationView: LottieAnimationView): LottieAnimationView {
        val fieldPadding : Int = context.resources.getDimension(R.dimen.game_board_field_padding).toInt() / howManyFieldsInRow
        lottieAnimationView.setPadding(fieldPadding, fieldPadding, fieldPadding, fieldPadding)
        return lottieAnimationView
    }

    private fun setScaleType(lottieAnimationView: LottieAnimationView) {
        lottieAnimationView.scaleType = ImageView.ScaleType.CENTER_CROP
    }

    private fun setBackgroundColor(lottieAnimationView: LottieAnimationView) {
        lottieAnimationView.setBackgroundColor(ContextCompat.getColor(context, R.color.appBackground))
    }

    private fun setOnClickListener(lottieAnimationView: LottieAnimationView) {
        lottieAnimationView.setOnClickListener { v ->
            (v as LottieAnimationView).setAnimation("cross.json")
            v.playAnimation()
        }
    }

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = howManyFieldsInRow*howManyFieldsInRow
}

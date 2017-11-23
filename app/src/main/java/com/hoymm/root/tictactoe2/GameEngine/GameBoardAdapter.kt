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

class GameBoardAdapter(private var context: Context, private var howManyFieldsInRow: Int) : BaseAdapter(){
    private var fieldLength: Int = 0

    companion object {
        val separateLineDivider = 150
        private val fieldPadding = dpToPx(10)
        private fun dpToPx(dp: Int): Float = dp * Resources.getSystem().displayMetrics.density
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): LottieAnimationView {
        val shorterSide = Math.min(parent!!.width, parent.height).toDouble()
        val separateLine : Double = (shorterSide/separateLineDivider)*(howManyFieldsInRow-1)/howManyFieldsInRow
        fieldLength = Math.ceil(shorterSide/howManyFieldsInRow - separateLine).toInt()
        return createNewBoardField()
    }

    private fun createNewBoardField(): LottieAnimationView {
        val myLottieAnimationView = LottieAnimationView(context)
        val fieldParams = LinearLayout.LayoutParams((fieldLength+0.5f).toInt(), (fieldLength+0.5f).toInt())

        myLottieAnimationView.layoutParams = fieldParams
        myLottieAnimationView.setPadding(fieldPadding.toInt()
                , fieldPadding.toInt()
                , fieldPadding.toInt()
                , fieldPadding.toInt())
        myLottieAnimationView.scaleType = ImageView.ScaleType.CENTER_CROP
        myLottieAnimationView.setBackgroundColor(ContextCompat.getColor(context, R.color.appBackground))


        myLottieAnimationView.setOnClickListener { v ->
            (v as LottieAnimationView).setAnimation("cross.json")
            v.playAnimation()
        }

        return myLottieAnimationView
    }

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = howManyFieldsInRow*howManyFieldsInRow
}

package com.hoymm.root.tictactoe2.GameEngine.GameActivityFragments.GameMiddleFragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hoymm.root.tictactoe2.R

/**
 * Created by Damian Muca (Kaizen) on 24.01.18
 */
class GameSettingsFrag : Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater!!.inflate(R.layout.game_middle_frag_settings, container, false)
}
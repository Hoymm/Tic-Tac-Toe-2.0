package com.hoymm.root.tictactoe2.GameEngine.GameActivityFragments.GameMiddleFragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.hoymm.root.tictactoe2.GameEngine.EnumClasses.Shape
import com.hoymm.root.tictactoe2.GameEngine.CommunicationInterfaces.CheckIsGameFinished
import com.hoymm.root.tictactoe2.GameEngine.CommunicationInterfaces.CurAppData
import com.hoymm.root.tictactoe2.R
import java.lang.ClassCastException

class GameMiddleFragment : Fragment(), CheckIsGameFinished {

    private lateinit var boardFrag : GameBoardFrag
    private lateinit var settingsFrag : Fragment

    private lateinit var curAppData: CurAppData


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try{
            curAppData = context as CurAppData
        }
        catch (exception : ClassCastException){
            throw ClassCastException(activity.toString() + " must implement CurAppData")
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater!!.inflate(R.layout.game_middle_frag, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAndAddFragments()
        hideFragment(settingsFrag)
    }

    private fun initAndAddFragments() {
        boardFrag = GameBoardFrag()
        boardFrag.arguments = arguments
        addNewFragment(R.id.game_middle_frag_id, boardFrag)

        settingsFrag = GameSettingsFrag()
        addNewFragment(R.id.game_middle_frag_id, settingsFrag)
    }

    private fun hideFragment(fragment : Fragment) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.hide(fragment)
        fragmentTransaction.commit()
    }

    fun showSettingsFragmentAndHideBoard() {
        // TODO create an animation to show Settings fragment
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.show(settingsFrag)
        fragmentTransaction.hide(boardFrag)
        fragmentTransaction.commit()
    }

    override fun checkIfSomeoneWon(): Shape? = boardFrag.checkIfSomeoneWon()

    override fun checkIfItIsADraw(): Boolean = boardFrag.checkIfItIsADraw()

    private fun addNewFragment(ID: Int, fragment: Fragment) {
        val fragmentManager = fragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(ID, fragment)
        fragmentTransaction.commit()
    }
}

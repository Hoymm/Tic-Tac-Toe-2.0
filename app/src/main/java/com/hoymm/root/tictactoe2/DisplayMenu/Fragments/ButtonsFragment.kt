package com.hoymm.root.tictactoe2.DisplayMenu.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.hoymm.root.tictactoe2.R

/**
 * Created by Damian Muca - Kaizen (12.09.17)
 */

abstract class ButtonsFragment : Fragment() {
    protected lateinit var buttons: Array<Button>
    protected abstract val listenerOfButton1: View.OnClickListener?
    protected abstract val listenerOfButton2: View.OnClickListener?
    protected abstract val listenerOfButton3: View.OnClickListener?
    protected abstract val listenerOfButton4: View.OnClickListener?

    override fun onCreateView
            (inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater!!.inflate(R.layout.menu_buttons_fragment, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linkButtonsWithXML(view)
        insertButtonsTextNames()
        setButtonsOnClickAction()
        temporaryDisableSomeButtons()
    }

    protected fun insertButtonNamesFromAnArrayID(arrayResourcesID: Int) {
        val buttonTextNames = context.resources.getStringArray(arrayResourcesID)
        for (i in buttons.indices)
            buttons[i].text = buttonTextNames[i]
    }

    private fun linkButtonsWithXML(view: View?) {
        buttons = Array<Button>(4, { _ -> view!!.findViewById(R.id.button1)})
        buttons[0] = view!!.findViewById(R.id.button1)
        buttons[1] = view.findViewById(R.id.button2)
        buttons[2] = view.findViewById(R.id.button3)
        buttons[3] = view.findViewById(R.id.button4)
    }

    protected open fun setButtonsOnClickAction() {
        buttons[0].setOnClickListener(listenerOfButton1)
        buttons[1].setOnClickListener(listenerOfButton2)
        buttons[2].setOnClickListener(listenerOfButton3)
        buttons[3].setOnClickListener(listenerOfButton4)
    }


    abstract fun temporaryDisableSomeButtons()
    protected abstract fun insertButtonsTextNames()
}

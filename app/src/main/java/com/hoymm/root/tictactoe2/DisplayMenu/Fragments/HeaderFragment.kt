package com.hoymm.root.tictactoe2.DisplayMenu.Fragments

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.hoymm.root.tictactoe2.R

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

abstract class HeaderFragment : Fragment() {
    private lateinit var headerText: TextView

    override fun onCreateView
            (inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? = inflater!!.inflate(R.layout.menu_header_fragment, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        headerText = view!!.findViewById(R.id.headerTextView)
        refreshHeaderText()
    }

    protected fun setHeaderTextUppercase(text: String) {
        this.headerText.text = text.toUpperCase()
    }

    protected abstract fun refreshHeaderText()
}

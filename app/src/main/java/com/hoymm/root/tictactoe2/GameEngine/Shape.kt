package com.hoymm.root.tictactoe2.GameEngine

/**
 * Created by Damian Muca (Kaizen) on 22.12.17.
 */
enum class Shape {
    circle, cross;

    override fun toString(): String = if (this == circle) "Circle" else "Cross"
}
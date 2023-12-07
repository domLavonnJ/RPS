package com.rps.view

import com.rps.bl.Game
import com.rps.constants.Constants

class Screen {
    companion object {
        fun startGame() {

            println(Constants.GREET_QUESTION)
            val greetAns = readLine()
            Game.processGame(greetAns!!)
        }
    }
}
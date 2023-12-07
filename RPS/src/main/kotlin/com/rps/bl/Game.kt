package com.rps.bl

import com.rps.constants.Constants
import java.util.Scanner
import kotlin.random.Random
import kotlin.random.nextInt

class Game {

    companion object {

        val rpsArr = arrayOf(RPSE.Rock, RPSE.Paper, RPSE.Scissors)
        val numArr = arrayOf(0,1,2)

        fun getGameType(gameType: String): String {
            val gameType = when(gameType) {
                Constants.SINGLE_PLAYER -> "SP"
                Constants.TWO_PLAYER -> "TP"
                else -> "Invalid"
            }
            return gameType
        }

        fun cpuPick(): RPSE {
            val randNum =  Random.nextInt(0..2)
            return rpsArr[randNum]
        }

        fun playerPick(pickNumber: Int): RPSE =  rpsArr[pickNumber]

        fun correctInput(playerPick: RPSE): Boolean {
            return (playerPick == RPSE.Rock
                   || playerPick == RPSE.Paper || playerPick == RPSE.Scissors)
        }

        fun pickWinner(pPick: RPSE, cPick: RPSE): String {
            if( pPick == RPSE.Rock && cPick == RPSE.Scissors ||
                pPick == RPSE.Paper && cPick == RPSE.Rock ||
                        pPick == RPSE.Scissors && cPick == RPSE.Paper) {
                    return "Player 1 wins!"
            }else if(pPick == RPSE.Rock && cPick == RPSE.Rock ||
                pPick == RPSE.Scissors && cPick == RPSE.Scissors ||
                pPick == RPSE.Paper && cPick == RPSE.Paper
            ) {
                return "It's a draw"
            } else {
                return "CPU wins!"
            }
        }

        fun processGame(greeting: String,)  {

            var gameSel = getGameType(greeting)
            var playerPickAns: Int?
            var playerFinalPick: RPSE
            var scanner = Scanner(System.`in`)
            var cpuChoice:RPSE

            while(gameSel == Constants.INVALID) {
                println("Please enter Single player or Two player")
                val retry = readLine()
                gameSel = getGameType(retry!!)
            }

            println(Constants.SELECT_QUESTION)
            playerPickAns = scanner.nextInt()
            playerFinalPick = playerPick(playerPickAns )

            while (!correctInput(playerFinalPick!!))
            {
                println("Enter either 0, 1, or 2!")
                playerPickAns = scanner.nextInt()

                if(playerPickAns!!  in  numArr){
                    playerFinalPick = playerPick(playerPickAns )
                }
                continue
            }
            cpuChoice = cpuPick()

            println( pickWinner(playerFinalPick, cpuChoice))
        }
    }
}
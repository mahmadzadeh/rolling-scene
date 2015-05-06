package com.ui.rollingscene

import org.scalatest.FunSuite

import scala.collection.immutable.Queue


class HillsTest extends FunSuite {
    val displayWindow = DisplayWindow(200, 100)
    val coverage      = ScreenCoverage(displayWindow)

    test("can create an empty columns") {
        Hills(Queue.empty,coverage)
    }

    test("given columns then call to add will add new col to the queue of cols") {
        assert(1 === Hills(Queue.empty, coverage).add.colQueue.size )
    }

    test("given columns with no column then call move will move nothing") {
        val columns = Hills(Queue.empty, coverage)

        assert(0 === columns.move.count)
    }

    test("given columns with one bar then call move will move one bar to new location based on velocity") {
        val columns = Hills(Queue.empty, coverage).add

        val barPosition = columns.columnPositions

        val newBarPosition = columns.move.columnPositions

        assert(barPosition != newBarPosition)
    }

    test("given columns when not enough columns on screen then call to removeOldestBar does nothing") {
        val velocity         = Velocity(-1,0) // moves 1 pix in one time unit not enough to move it off screen
        val veryNarrowScreen = DisplayWindow(2, 100)
        val narrowCoverage  = ScreenCoverage(veryNarrowScreen)

        val columns = Hills(Queue.empty, narrowCoverage, velocity).add.move

        assert(columns.count === columns.removeOffScreen.count )
    }

    test("given columns then calling add will add more columns if required") {
        val velocity        = Velocity(-4,0,1) // moves 4 pix in one time unit

        val columns = Hills(Queue.empty, coverage, velocity).add.move.add.move.add

        assert( columns.count > 0)
    }
}

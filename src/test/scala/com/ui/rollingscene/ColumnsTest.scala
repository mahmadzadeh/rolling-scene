package com.ui.rollingscene

import org.scalatest.FunSuite
import scala.collection.immutable.Queue


class ColumnsTest extends FunSuite {
    val displayWindow = DisplayWindow(200, 100)
    val coverage      = RollingSceneCoverage(displayWindow)

    test("can create an empty columns") {
        Columns(Queue.empty,coverage)
    }

    test("given columns then call to add will add new col to the queue of cols") {
        assert(1 === Columns(Queue.empty, coverage).add.colQueue.size )
    }

    test("given columns with no column then call move will move nothing") {
        val columns = Columns(Queue.empty, coverage)

        assert(0 === columns.move.count)
    }

    test("given columns with one bar then call move will move one bar to new location based on velocity") {
        val columns = Columns(Queue.empty, coverage).add

        val barPosition = columns.columnPositions

        val newBarPosition = columns.move.columnPositions

        assert(barPosition != newBarPosition)
    }

    test("given columns when not enough columns on screen then call to removeOldestBar does nothing") {
        val velocity        = ColumnVelocity() // moves 1 pix in one time unit not enough to move it off screen
        val veryNarrowScreen = DisplayWindow(2, 100)
        val narrowCoverage  = RollingSceneCoverage(veryNarrowScreen)

        val columns = Columns(Queue.empty, narrowCoverage, velocity).add.move

        assert(columns.count === columns.removeOffScreen.count )
    }

    test("given columns then calling add will add more columns if required") {
        val velocity        = ColumnVelocity(-4,0,1) // moves 4 pix in one time unit

        // the third call to add will add 2 columns as opposed to one since there is room for 2
        // by the time things are moved to the left
        val columns = Columns(Queue.empty, coverage, velocity).add.move.add.move.add

        assert(4 === columns.count )
    }
}

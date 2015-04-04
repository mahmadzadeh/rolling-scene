package com.ui.rollingscene

import org.scalatest.FunSuite
import scala.collection.immutable.Queue


class VerticalBarsTest extends FunSuite {
    val displayWindow = DisplayWindow(200, 100)
    val coverage      = RollingSceneCoverage(displayWindow)

    test("can create an empty vertical bars") {
        VerticalBars(Queue.empty,coverage)
    }

    test("given vertical bars then call to add will add new bar to the queue of bars") {
        assert(1 === VerticalBars(Queue.empty, coverage).add.bars.size )
    }

    test("given vertical bars with no bars then call move will move nothing") {
        val bars = VerticalBars(Queue.empty, coverage)

        assert(0 === bars.move.count)
    }

    test("given vertical bars with one bar then call move will move one bar to new location based on velocity") {
        val bars = VerticalBars(Queue.empty, coverage).add

        val barPosition = bars.barPositions

        val newBarPosition = bars.move.barPositions

        assert(barPosition != newBarPosition)
    }

    test("given vertical bars when not enough bars on screen then call to removeOldestBar does nothing") {
        val velocity        = VerticalBarVelocity() // moves 1 pix in one time unit not enough to move it off screen
        val veryNarrowScreen = DisplayWindow(2, 100)
        val narrowCoverage  = RollingSceneCoverage(veryNarrowScreen)

        val bars = VerticalBars(Queue.empty, narrowCoverage, velocity).add.move

        assert(bars.count === bars.removeOffScreen.count )
    }

    test("given vertical bars then calling add will add more bars if required") {
        val velocity        = VerticalBarVelocity(-4,0,1) // moves 4 pix in one time unit

        // the third call to add will add 2 columns as opposed to one since there is room for 2
        // by the time things are moved to the left
        val bars = VerticalBars(Queue.empty, coverage, velocity).add.move.add.move.add

        assert(4 === bars.count )

    }
}

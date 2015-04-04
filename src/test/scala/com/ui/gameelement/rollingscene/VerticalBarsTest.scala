package com.ui.gameelement.rollingscene

import org.scalatest.FunSuite
import scala.collection.immutable.Queue


class VerticalBarsTest extends FunSuite {
    val displayWindow = DisplayWindow(200, 100)
    val coverage = RollingSceneCoverage(displayWindow)

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
        val veryNarrowScreen = DisplayWindow(2, 100)
        val narrowCoverage  = RollingSceneCoverage(veryNarrowScreen)

        val bars = VerticalBars(Queue.empty, narrowCoverage).add.move.move

        assert(bars.count === bars.removeOffScreen.count )

    }

    test("given vertical bars then calling add will add more bars if required") {

        val bars = VerticalBars(Queue.empty, coverage).add.add.add

        assert(3 === bars.count )

    }



}

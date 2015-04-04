package com.ui.rollingscene

import org.scalatest.FunSuite
import scala.collection.immutable.Queue

class RollingSceneTest extends FunSuite {

    val display = RollingSceneCoverage(DisplayWindow(200, 100))

    test("given a series of vertical bars then a rolling scene can be created") {
        val rollingScene = new RollingScene(VerticalBars(Queue.empty, display))
    }

    test("given a rolling scene when no bars then call to refresh adds the first bar") {
        val bars = VerticalBars(Queue.empty, display)

        val rollingScene = new RollingScene(bars)

        assert(1===rollingScene.refresh.verticalBars.count)
    }

    /**
     * with velocity of -1px/time_unit each call to refresh moves things one pixel to the left
     * we only add vertical bars on the left if the screen has empty space on the left to be
     * fit a bar. otherwise nothing will be added.
     * each element is 2 pix wide so 5 calls to refresh are required to add a new element
     * note to determine if we should add a column we see if we can fit a column from the last
     * column + the width of the last column up to display width
     */
    test("given a rolling scene when not enough vertical bars on screen then call to refresh adds more bars") {
        val velocity = VerticalBarVelocity(-1,-0,1)

        assertResult(2) {
            new RollingScene(VerticalBars(Queue.empty, display, velocity))
            .refresh
            .refresh
            .refresh
            .refresh
            .refresh.verticalBars.count
        }
    }

}

package com.ui.gameelement.rollingscene

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

    test("given a rolling scene when not enough vertical bars on screen then call to refresh adds more bars") {
        assertResult(3) {
            new RollingScene(VerticalBars(Queue.empty, display))
            .refresh
            .refresh
            .refresh.verticalBars.count
        }
    }

}

package com.ui.rollingscene

import org.scalatest.FunSuite


class RollingRangeTest extends FunSuite {

    val display  = DisplayWindow(100,200)
    val sceneCov = RollingSceneCoverage(display,100)

    test("given RollingRange then call to getRange returns a range that's within window range ") {
        val n = 100

        val vals = 0 to 360 map { i=>
            RollingRange.getNextRandomPoint(display)
        }
    }
}


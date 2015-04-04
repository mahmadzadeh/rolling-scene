package com.ui.rollingscene

import org.scalatest.FunSuite
import java.awt.Point

class OneVerticalBarFactoryTest extends FunSuite {

        val displayWindow   = DisplayWindow(100, 100)
        val sceneCoverage   = RollingSceneCoverage(displayWindow)

    test("given a vertical bar factory then create a vertical bar consistent of n blocks") {
        val startingPoint = new Point(0,0)

        val actual = OneVerticalBarFactory.create(startingPoint, sceneCoverage)

        assert(0 === actual.topLeft.x)
        assert(0 === actual.topLeft.y)
    }

    test("given a vertical bar factory when display height 100 px and 75% scene coverage required then create m blocks") {
        assert( 37 === OneVerticalBarFactory.verticalBarsRequiredForCoverage(sceneCoverage))
    }

    test("given a vertical bar factory when display height 100 px and 10% scene coverage required then create m blocks") {
        assert( 5 === OneVerticalBarFactory.verticalBarsRequiredForCoverage(RollingSceneCoverage(displayWindow, 10)))
    }

    test("given a vertical bar factory when no element required to be added then call to horizontal bars required will return 0") {
        assert( 0 === OneVerticalBarFactory.barsRequiredForCoverageHorizontally(new Point(101,0), sceneCoverage))
    }

    test("given a vertical bar factory when one element required to be added then call to horizontal bars required will return 1") {
        val fromPoint = 98
        assertResult((100-fromPoint)/OneVerticalBarFactory.BAR_WIDTH){
            OneVerticalBarFactory.barsRequiredForCoverageHorizontally(new Point(fromPoint,0), sceneCoverage)
        }
    }

    test("given a vertical bar factory then call to horizontal bars required will return the count of bars required to cover screen horizontally from given point") {
        val fromPoint: Int = 50
        assertResult( (100-fromPoint)/OneVerticalBarFactory.BAR_WIDTH ) {
            OneVerticalBarFactory.barsRequiredForCoverageHorizontally(new Point(fromPoint,0), sceneCoverage)
        }
    }

    test("given a vertical bar factory then call to createFillScreen will return enough bars on the right to fill the screen") {

        val lastBar  = OneVerticalBarFactory.create(new Point(50,0), sceneCoverage)
        val expected = OneVerticalBarFactory.barsRequiredForCoverageHorizontally(new Point(50,0), sceneCoverage)
        val bars     = OneVerticalBarFactory.createFillScreen(lastBar.topLeft, sceneCoverage)

        assert( expected === bars.size)
    }


}

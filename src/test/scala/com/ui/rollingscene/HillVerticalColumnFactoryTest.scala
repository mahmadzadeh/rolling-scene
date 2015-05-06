package com.ui.rollingscene

import java.awt.Point

import org.scalatest.FunSuite

class HillVerticalColumnFactoryTest extends FunSuite {

        val displayWindow   = DisplayWindow(100, 100)
        val sceneCoverage   = ScreenCoverage(displayWindow)

    test("given a column factory then create a vertical bar consistent of n blocks") {
        val startingPoint = new Point(0,0)

        val actual = VerticalColumnFactory.create(startingPoint, sceneCoverage)

        assert(0 === actual.topLeft.x)
        assert(0 === actual.topLeft.y)
    }

    test("given a column factory when no element required to be added then call to horizontal bars required will return 0") {
        assert( 0 === VerticalColumnFactory.colsRequiredForCoverageHorizontally(new Point(101,0), sceneCoverage))
    }

    test("given a column factory when one element required to be added then call to horizontal bars required will return 1") {
        val fromPoint = 98
        assertResult((100-fromPoint)/VerticalColumnFactory.COL_WIDTH){
            VerticalColumnFactory.colsRequiredForCoverageHorizontally(new Point(fromPoint,0), sceneCoverage)
        }
    }

    test("given a column factory then call to colsRequiredForCoverageHorizontally will return the count of bars required to cover screen horizontally from given point") {
        val fromPoint: Int = 50
        assertResult( (100-fromPoint)/VerticalColumnFactory.COL_WIDTH ) {
            VerticalColumnFactory.colsRequiredForCoverageHorizontally(new Point(fromPoint,0), sceneCoverage)
        }
    }

    test("given a column factory then call to createFillScreen will return enough bars on the right to fill the screen") {

        val lastBar  = VerticalColumnFactory.create(new Point(50,0), sceneCoverage)
        val expected = VerticalColumnFactory.colsRequiredForCoverageHorizontally(new Point(50,0), sceneCoverage)
        val bars     = VerticalColumnFactory.fillScreen(lastBar.topLeft, sceneCoverage)

        assert( expected === bars.size)
    }

}

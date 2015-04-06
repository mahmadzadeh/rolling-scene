package com.ui.rollingscene

import org.scalatest.FunSuite
import java.awt.Point

class OneColumnFactoryTest extends FunSuite {

        val displayWindow   = DisplayWindow(100, 100)
        val sceneCoverage   = RollingSceneCoverage(displayWindow)

//    test("given a column factory then create a vertical bar consistent of n blocks") {
//        val startingPoint = new Point(0,0)
//
//        val actual = ColumnFactory.create(startingPoint, sceneCoverage)
//
//        assert(0 === actual.topLeft.x)
//        assert(0 === actual.topLeft.y)
//    }
//
//    test("given a column factory when display height 100 px and 75% scene coverage required then create m rectangles") {
//        assert( 37 === ColumnFactory.colElementsRequiredForCoverage(sceneCoverage))
//    }
//
//    test("given a column factory when display height 100 px and 10% scene coverage required then create m rectangles") {
//        assert( 5 === ColumnFactory.colElementsRequiredForCoverage(RollingSceneCoverage(displayWindow, 10)))
//    }
//
//    test("given a column factory when no element required to be added then call to horizontal bars required will return 0") {
//        assert( 0 === ColumnFactory.colsRequiredForCoverageHorizontally(new Point(101,0), sceneCoverage))
//    }
//
//    test("given a column factory when one element required to be added then call to horizontal bars required will return 1") {
//        val fromPoint = 98
//        assertResult((100-fromPoint)/ColumnFactory.COL_WIDTH){
//            ColumnFactory.colsRequiredForCoverageHorizontally(new Point(fromPoint,0), sceneCoverage)
//        }
//    }
//
//    test("given a column factory then call to colsRequiredForCoverageHorizontally will return the count of bars required to cover screen horizontally from given point") {
//        val fromPoint: Int = 50
//        assertResult( (100-fromPoint)/ColumnFactory.COL_WIDTH ) {
//            ColumnFactory.colsRequiredForCoverageHorizontally(new Point(fromPoint,0), sceneCoverage)
//        }
//    }
//
//    test("given a column factory then call to createFillScreen will return enough bars on the right to fill the screen") {
//
//        val lastBar  = ColumnFactory.create(new Point(50,0), sceneCoverage)
//        val expected = ColumnFactory.colsRequiredForCoverageHorizontally(new Point(50,0), sceneCoverage)
//        val bars     = ColumnFactory.createFillScreen(lastBar.topLeft, sceneCoverage)
//
//        assert( expected === bars.size)
//    }

    test("given a column factory and a coverage of 75% then call to create will create a column of both white and blue blocks") {
        val initialPosition  = new Point(10,10)

        val col = ColumnFactory.create(initialPosition, RollingSceneCoverage(DisplayWindow(100,200), 100))

        println(col.toString)
    }


}

package com.ui.rollingscene

import org.scalatest.FunSuite
import java.awt.Point

class RollingSceneCoverageTest extends FunSuite {


    test("given a screen with 100 px in height and scene coverage of 75% then vertical coverage is 75 pixels ") {

        assertResult(75){
            RollingSceneCoverage(DisplayWindow(100,100)).verticalPixelCountForCoverage
        }
    }

    test("given a screen with 100 px in height and scene coverage of 10% then vertical coverage is 10 pixels ") {

        assertResult(10){
            RollingSceneCoverage(DisplayWindow(100,100), 10).verticalPixelCountForCoverage
        }
    }

    test("given a screen with 100 px in height and scene coverage of 100% then vertical coverage is 100 pixels ") {

        assertResult(100){
            RollingSceneCoverage(DisplayWindow(100,100), 100).verticalPixelCountForCoverage
        }
    }

    test("given a screen with 0 px in height and scene coverage of 100% then vertical coverage is 0 pixels ") {

        assertResult(0){
            RollingSceneCoverage(DisplayWindow(100,0), 100).verticalPixelCountForCoverage
        }
    }

    test("given a screen 100 px wide and 100px high and 75 coverage then firstBarLocation returns the top left corner of the very first bar") {

        assertResult(new Point(100,12)){
            RollingSceneCoverage(DisplayWindow(100,100)).firstBar
        }
    }

    test("given a screen 100 px wide and 100px high and 80 coverage then firstBarLocation returns the top left corner of the very first bar") {

        assertResult(new Point(100,10)){
            RollingSceneCoverage(DisplayWindow(100,100), 80).firstBar
        }
    }

    test("given a screen 100 px wide then barCount returns the number of bars that can fit on screen") {
        val w = 117

        val expected = ((w.toDouble)/ColumnFactory.COL_WIDTH).toInt

        assertResult(expected ){
            RollingSceneCoverage(DisplayWindow(w,100)).horizontalBarCount
        }
    }

}

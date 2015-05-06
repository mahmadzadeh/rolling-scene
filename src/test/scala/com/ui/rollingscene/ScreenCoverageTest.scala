package com.ui.rollingscene

import java.awt.Point

import org.scalatest.FunSuite

class ScreenCoverageTest extends FunSuite {


    test("given a screen with 100 px in height and scene coverage of 75% then vertical coverage is 75 pixels ") {

        assertResult(75){
            ScreenCoverage(DisplayWindow(100,100)).verticalPixelCountForCoverage
        }
    }

    test("given a screen with 100 px in height and scene coverage of 10% then vertical coverage is 10 pixels ") {

        assertResult(10){
            ScreenCoverage(DisplayWindow(100,100), 10).verticalPixelCountForCoverage
        }
    }

    test("given a screen with 100 px in height and scene coverage of 100% then vertical coverage is 100 pixels ") {

        assertResult(100){
            ScreenCoverage(DisplayWindow(100,100), 100).verticalPixelCountForCoverage
        }
    }

    test("given a screen with 0 px in height and scene coverage of 100% then vertical coverage is 0 pixels ") {

        assertResult(0){
            ScreenCoverage(DisplayWindow(100,0), 100).verticalPixelCountForCoverage
        }
    }

    test("given a screen 100 px wide and 100px high and 75 coverage then firstBarLocation returns the top left corner of the very first bar") {

        assertResult(new Point(100,12)){
            ScreenCoverage(DisplayWindow(100,100)).firstColumnTopLeft
        }
    }

    test("given a screen 100 px wide and 100px high and 80 coverage then firstBarLocation returns the top left corner of the very first bar") {

        assertResult(new Point(100,10)){
            ScreenCoverage(DisplayWindow(100,100), 80).firstColumnTopLeft
        }
    }

    test("given a screen 100 px wide then barCount returns the number of bars that can fit on screen") {
        val w = 117

        val expected = ((w.toDouble)/VerticalColumnFactory.COL_WIDTH).toInt

        assertResult(expected ){
            ScreenCoverage(DisplayWindow(w,100)).horizontalBarCount
        }
    }

}

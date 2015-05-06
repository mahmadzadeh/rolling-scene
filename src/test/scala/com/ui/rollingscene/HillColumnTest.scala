package com.ui.rollingscene

import org.scalatest.FunSuite
import java.awt.Point

class HillColumnTest extends FunSuite {

    test("given a vertical bar then call to next bar returns top left corner of the next bar") {
        val bar = VerticalColumnFactory.create(new Point, ScreenCoverage(DisplayWindow(100,200), 100))

        if(bar.boundingBox.width ==0)
            assert( new Point(0,0) === bar.nextColumnToRight)
        else
            assert( new Point(VerticalColumnFactory.COL_WIDTH,0) === bar.nextColumnToRight)
    }
}

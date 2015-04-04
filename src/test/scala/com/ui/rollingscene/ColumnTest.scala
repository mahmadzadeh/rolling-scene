package com.ui.rollingscene

import org.scalatest.FunSuite
import java.awt.Point

class ColumnTest extends FunSuite {

    test("given a vertical bar then call to next bar returns top left corner of the next bar") {
        val bar = ColumnFactory.create(new Point, RollingSceneCoverage(DisplayWindow(100,100)))

        assert( new Point(ColumnFactory.COL_WIDTH,0) === bar.nextColumnToRight)
    }

    test("given a vertical bar then call to move will move the bar to new location") {
        val bar = ColumnFactory.create(new Point, RollingSceneCoverage(DisplayWindow(100,100)))

        assert( new Point(ColumnFactory.COL_WIDTH,0) === bar.nextColumnToRight)
    }

}

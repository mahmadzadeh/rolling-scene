package com.ui.rollingscene

import java.awt.Point

case class ScreenCoverage(displayWindow: DisplayWindow, coverage: Int = 75) {

    def verticalPixelCountForCoverage: Int =
        ((coverage / 100.0) * displayWindow.h).toInt

    def horizontalBarCount: Int = {
        ((displayWindow.w.toDouble) / VerticalColumnFactory.COL_WIDTH).toInt
    }

    /**
     * top left corner of a the very first column that gets printed on the screen
     * as the scene moves from L <- R
     */
    def firstColumnTopLeft: Point = {
        val x = displayWindow.w
        // from total screen h pixelCountForCoverage pixels will be covered the rest is uncovered screen
        val uncoveredPixels = displayWindow.h - verticalPixelCountForCoverage
        val y = (uncoveredPixels / 2.0).toInt

        new Point(x, y)
    }


}

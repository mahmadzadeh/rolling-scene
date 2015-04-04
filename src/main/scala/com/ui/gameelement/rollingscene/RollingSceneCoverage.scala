package com.ui.gameelement.rollingscene

import java.awt.Point

case class RollingSceneCoverage(displayWindow: DisplayWindow, coverage: Int = 75) {
    def verticalPixelCountForCoverage: Int =
        ((coverage / 100.0) * displayWindow.h).toInt

    def horizontalBarCount: Int = {
        ((displayWindow.w.toDouble) / OneVerticalBarFactory.BAR_WIDTH).toInt
    }

    def firstBar: Point = {
        val x = displayWindow.w
        // from total screen h pixelCountForCoverage pixels will be covered the rest is uncovered screen
        val uncoveredPixels = displayWindow.h - verticalPixelCountForCoverage
        val y = (uncoveredPixels / 2.0).toInt

        new Point(x, y)
    }


}

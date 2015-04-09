package com.ui.rollingscene

import com.ui.rollingscene.DisplayRectangle._
import java.awt.Point


object ColumnFactory {
    val COL_WIDTH                 = DEFAULT_ELEMENT_WIDTH
    val COL_SINGLE_ELEMENT_HEIGHT = DEFAULT_ELEMENT_HEIGHT

    def create(topLeft: Point, coverage: RollingSceneCoverage): HillColumn = {

        val colTop = RollingRange.getNextRandomPoint(coverage.displayWindow)

        val rectangles = getRangeRequiredForHill(coverage.displayWindow.h, colTop) map {
            y:Int  =>
                GreenDisplayRectangle( xOffset(topLeft.x, 0), y, COL_WIDTH, COL_SINGLE_ELEMENT_HEIGHT)
        }

        HillColumn(topLeft, rectangles)
    }

    def fillScreen(point: Point, coverage: RollingSceneCoverage): Seq[HillColumn] = {
        def createOneColumn(acc:Seq[HillColumn], i:Int): Seq[HillColumn] = {
            if( i >= 1 ){
                val fromPoint = if(acc.isEmpty) point else acc.last.nextColumnToRight
                createOneColumn(acc :+ create(fromPoint, coverage), i-1)
            } else {
                acc
            }
        }

        createOneColumn(Seq[HillColumn](), colsRequiredForCoverageHorizontally(point,coverage))
    }

    def colsRequiredForCoverageHorizontally(fromPoint:Point, sceneCoverage:RollingSceneCoverage):Int = {
        val uncovered= sceneCoverage.displayWindow.w - fromPoint.x

        if(uncovered <= 0 ) 0 else (uncovered.toDouble / COL_WIDTH).toInt
    }

    private def getRangeRequiredForHill(h: Int, top: Int): Range =
        (h - COL_SINGLE_ELEMENT_HEIGHT to top by -COL_SINGLE_ELEMENT_HEIGHT)

}

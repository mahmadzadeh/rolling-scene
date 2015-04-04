package com.ui.rollingscene

import com.ui.rollingscene.DisplayRectangle._
import java.awt.Point


object ColumnFactory {
    val COL_WIDTH                 = DEFAULT_ELEMENT_WIDTH
    val COL_SINGLE_ELEMENT_HEIGHT = DEFAULT_ELEMENT_HEIGHT

    def create(topLeft: Point, coverage: RollingSceneCoverage): Column = {
        val rectangles = 0 until (colElementsRequiredForCoverage(coverage)) map {
            y =>
                WhiteDisplayRectangle(
                    xOffset(topLeft.x, 0),
                    yOffset(topLeft.y, y), COL_WIDTH, COL_SINGLE_ELEMENT_HEIGHT)
        }

        Column(topLeft, rectangles)
    }

    def createFillScreen(point: Point, coverage: RollingSceneCoverage): Seq[Column] = {
        def createOne(acc:Seq[Column], i:Int): Seq[Column] = {
            if( i >= 1 ){
                val fromPoint = if(acc.isEmpty) point else acc.last.nextColumnToRight
                createOne(acc :+ create(fromPoint, coverage), i-1)
            } else {
                acc
            }
        }

        createOne(Seq[Column](), colsRequiredForCoverageHorizontally(point,coverage))
    }


    def colsRequiredForCoverageHorizontally(fromPoint:Point, sceneCoverage:RollingSceneCoverage):Int = {
        val uncovered= sceneCoverage.displayWindow.w - fromPoint.x         

        if(uncovered <= 0 ) 0 else (uncovered.toDouble / COL_WIDTH).toInt
    }

    def colElementsRequiredForCoverage(sceneCoverage:RollingSceneCoverage):Int = {
        val pxCountForCoverage:Double = sceneCoverage.verticalPixelCountForCoverage

        ( pxCountForCoverage / COL_SINGLE_ELEMENT_HEIGHT).toInt
    }
}

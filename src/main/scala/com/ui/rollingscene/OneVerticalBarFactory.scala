package com.ui.rollingscene

import com.ui.rollingscene.DisplayRectangle._
import java.awt.Point


object OneVerticalBarFactory {
    val BAR_WIDTH                 = DEFAULT_ELEMENT_WIDTH
    val BAR_SINGLE_ELEMENT_HEIGHT = DEFAULT_ELEMENT_HEIGHT

    def create(topLeft: Point, coverage: RollingSceneCoverage): VerticalBar = {
        val parts = 0 until (verticalBarsRequiredForCoverage(coverage)) map {
            y =>
                WhiteDisplayRectangle(
                    xOffset(topLeft.x, 0),
                    yOffset(topLeft.y, y), BAR_WIDTH, BAR_SINGLE_ELEMENT_HEIGHT)
        }

        VerticalBar(topLeft, parts)
    }

    def createFillScreen(point: Point, coverage: RollingSceneCoverage): Seq[VerticalBar] = {
        def createOne(acc:Seq[VerticalBar], i:Int): Seq[VerticalBar] = {
            if( i >= 1 ){
                val fromPoint = if(acc.isEmpty) point else acc.last.nextBarTopLeft
                createOne(acc :+ create(fromPoint, coverage), i-1)
            } else {
                acc
            }
        }

        createOne(Seq[VerticalBar](), barsRequiredForCoverageHorizontally(point,coverage))
    }


    def barsRequiredForCoverageHorizontally(fromPoint:Point, sceneCoverage:RollingSceneCoverage):Int = {
        val uncovered= sceneCoverage.displayWindow.w - fromPoint.x         

        if(uncovered <= 0 ) 0 else (uncovered.toDouble / BAR_WIDTH).toInt
    }

    def verticalBarsRequiredForCoverage(sceneCoverage:RollingSceneCoverage):Int = {
        val pxCountForCoverage:Double = sceneCoverage.verticalPixelCountForCoverage

        ( pxCountForCoverage / BAR_SINGLE_ELEMENT_HEIGHT).toInt
    }
}

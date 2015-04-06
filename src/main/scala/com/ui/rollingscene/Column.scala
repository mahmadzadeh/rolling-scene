package com.ui.rollingscene

import java.awt.{Graphics, Rectangle, Point}

case class Column(topLeft:Point, rectangles: Seq[DisplayRectangle]) {
    require(!rectangles.isEmpty)

    def boundingBox:Rectangle = {
        val height = rectangles.foldLeft(0) { (sum, a )  => sum + a.boundingBox.height }

        new Rectangle(topLeft.x, topLeft.y, rectangles(0).boundingBox.width,height)
    }

    def nextColumnToRight:Point = new Point (topLeft.x + boundingBox.width, topLeft.y)

    def draw(g:Graphics) = rectangles.foreach(_.draw(g))

    def move(rollingScene:RollingSceneCoverage, velocityCalc:Velocity):Column   = {
        val newLocation = new Point(velocityCalc.x1(topLeft.x), velocityCalc.y1(topLeft.y))

        Column(newLocation, rectangles.map(_.moveTo(newLocation)))
    }

    override def toString:String = {
        val colorsAndBox = rectangles.collect {
            case rec => s"${rec.boundingBox} color${rec.color}"
            }
        s"TOP left: ${topLeft} blocks ${colorsAndBox.mkString("\n")}"
    }
}

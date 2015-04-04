package com.ui.rollingscene

import java.awt.{Graphics, Rectangle, Point}

case class VerticalBar(topLeft:Point, parts: Seq[DisplayRectangle]) {
    require(!parts.isEmpty)

    def boundingBox:Rectangle = {
        val height = parts.foldLeft(0) { (sum, a )  => sum + a.boundingBox.height }

        new Rectangle(topLeft.x, topLeft.y, parts(0).boundingBox.width,height)
    }

    def nextBarTopLeft:Point = new Point (topLeft.x + boundingBox.width, topLeft.y)

    def draw(g:Graphics) = parts.foreach(_.draw(g))

    def move(rollingScene:RollingSceneCoverage, velocityCalc:Velocity):VerticalBar   = {
        val newLocation = new Point(velocityCalc.x1(topLeft.x), velocityCalc.y1(topLeft.y))

        OneVerticalBarFactory.create(newLocation, rollingScene)
    }
}

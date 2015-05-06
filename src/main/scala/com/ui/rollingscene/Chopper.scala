package com.ui.rollingscene

import java.awt.{Rectangle, Graphics, Point}
import java.awt.image.BufferedImage

case class Chopper(topLeft:Point, velocity:Velocity, chopperImages: Seq[BufferedImage], displayWindow: DisplayWindow ) {

    def newLocation: Point = {
        val possibleNewLocation = new Point(velocity.x1(topLeft.x), velocity.y1(topLeft.y))
        val visibleArea         = new Rectangle(0, 0, displayWindow.w - boundingBox.width, displayWindow.h - boundingBox.height)

        if(isInsideVisibleWindow(possibleNewLocation, visibleArea))
            possibleNewLocation
        else
            topLeft
    }

    private def isInsideVisibleWindow(possibleNewLocation: Point, window: Rectangle): Boolean = {
        window.contains(possibleNewLocation)
    }

    def move: Chopper =
        Chopper(newLocation, velocity, chopperImages.tail :+ chopperImages.head, displayWindow)

    def moveForward:Chopper =
        Chopper(topLeft, velocity.increaseInX, chopperImages, displayWindow)


    def moveBackward:Chopper = Chopper(topLeft, velocity.decreaseInX, chopperImages, displayWindow)

    def moveDown:Chopper = Chopper(topLeft, velocity.increaseInY, chopperImages, displayWindow)

    def moveUp:Chopper   = Chopper(topLeft, velocity.decreaseInY, chopperImages, displayWindow)

    def draw(g:Graphics):Unit = g.drawImage(chopperImages.head, topLeft.x, topLeft.y, null)

    def moveTo(location:Point) : Chopper = Chopper(location, velocity, chopperImages, displayWindow)

    def boundingBox: Rectangle  = new Rectangle(topLeft.x, topLeft.y,
                                                chopperImages.head.getWidth,
                                                chopperImages.head.getHeight)

}

package com.ui.rollingscene

import java.awt.{Rectangle, Graphics, Point}
import java.awt.image.BufferedImage

case class Chopper(topLeft:Point, velocity:Velocity, chopperImages: Seq[BufferedImage] ) {
    def newLocation: Point =
        new Point(velocity.x1(topLeft.x), velocity.y1(topLeft.y))

    def move: Chopper =
        Chopper(newLocation, velocity, chopperImages.tail :+ chopperImages.head)

    def moveForward:Chopper = Chopper(topLeft, velocity.increaseInX, chopperImages)

    def moveBackward:Chopper = Chopper(topLeft, velocity.decreaseInX, chopperImages)

    def moveDown:Chopper = Chopper(topLeft, velocity.increaseInY, chopperImages)

    def moveUp:Chopper   = Chopper(topLeft, velocity.decreaseInY, chopperImages)

    def draw(g:Graphics):Unit = g.drawImage(chopperImages.head, topLeft.x, topLeft.y, null)

    def boundingBox: Rectangle  = new Rectangle(topLeft.x, topLeft.y,
                                                chopperImages.head.getWidth,
                                                chopperImages.head.getHeight)

}

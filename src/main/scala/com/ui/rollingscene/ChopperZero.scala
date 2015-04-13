package com.ui.rollingscene

import java.awt.{Rectangle, Graphics, Point}
import java.awt.image.BufferedImage

abstract class Chopper(topLeft: Point, velocity: Velocity) {
    val image: BufferedImage

    def move:Chopper

    def draw(g: Graphics): Unit = g.drawImage(image,topLeft.x, topLeft.y, null )

    def boundingBox:Rectangle = new Rectangle(topLeft.x, topLeft.y, image.getWidth, image.getHeight)

    def newLocation:Point =  {
        new Point(velocity.x1(topLeft.x), velocity.y1(topLeft.y))
    }
}

class ChopperZero(topLeft: Point, velocity: Velocity) extends Chopper (topLeft: Point, velocity: Velocity){
    override val image = ImageCache.load("/cobra_0.jpg").getOrElse(throw new RuntimeException("unable to load chopper image 0"))
    override def move:Chopper    = new ChopperOne(newLocation, velocity)
}

class ChopperOne(topLeft: Point, velocity: Velocity) extends Chopper (topLeft: Point, velocity: Velocity){
    override val image = ImageCache.load("/cobra_1.jpg").getOrElse(throw new RuntimeException("unable to load chopper image 1"))
    override def move:Chopper    = new ChopperTwo(newLocation, velocity)
}

class ChopperTwo(topLeft: Point, velocity: Velocity) extends Chopper (topLeft: Point, velocity: Velocity){
    override val image = ImageCache.load("/cobra_2.jpg").getOrElse(throw new RuntimeException("unable to load chopper image 2"))

    override def move:Chopper    = new ChopperThree(newLocation, velocity)
}

class ChopperThree(topLeft: Point, velocity: Velocity) extends Chopper (topLeft: Point, velocity: Velocity){
    override val image       = ImageCache.load("/cobra_3.jpg").getOrElse(throw new RuntimeException("unable to load chopper image3"))
    override def move:Chopper    = new ChopperZero(newLocation, velocity)
}

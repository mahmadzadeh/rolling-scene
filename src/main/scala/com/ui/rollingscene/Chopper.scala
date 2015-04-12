package com.ui.rollingscene

import java.awt.{Graphics, Point}
import scala.util.Try
import javax.imageio.ImageIO

class Chopper(topLeft: Point, velocity: Velocity) {
    val image       = Try {
        ImageIO.read(getClass.getResourceAsStream("/cobra_2.jpg"))
    }.getOrElse(throw new IllegalStateException("Unable to load choppler image"))

    val xs      = List[Int]()
    val ys      = List[Int]()

    def move:Chopper    = new Chopper(new Point(velocity.x1(topLeft.x), velocity.y1(topLeft.y)), velocity)

    def draw(g: Graphics): Unit = g.drawImage(image,topLeft.x, topLeft.y, null )

}

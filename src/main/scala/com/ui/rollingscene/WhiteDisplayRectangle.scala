package com.ui.rollingscene

import java.awt.{Point, Color}
import java.awt.Color._
import com.util.random.RandomNumberGenerator

case class WhiteDisplayRectangle(x: Int, y: Int, width: Int, height: Int)
    extends DisplayRectangle(x, y, width, height) {
    override val color: Color =  WHITE

    def moveTo(loc:Point):WhiteDisplayRectangle = WhiteDisplayRectangle(x + ( loc.x - x) , y, width, height)
}
case class GreenDisplayRectangle(x: Int, y: Int, width: Int, height: Int)
    extends DisplayRectangle(x, y, width, height) {
    override val color: Color =  new Color (0, RandomNumberGenerator.next(10 to 246), 0)

    def moveTo(loc:Point):GreenDisplayRectangle = GreenDisplayRectangle(x + ( loc.x - x) , y, width, height)
}

case class Star(location:Point) extends DisplayRectangle(location.x, location.y, 1, 1){
    val possibleStarColours =
        List(WHITE,
            new Color (255, 69, 0),
            new Color (255, 215, 0),
            new Color (0,191,255),
            new Color (173,255,47))

    override def moveTo(loc: Point): DisplayRectangle = this

    override val color: Color = possibleStarColours(RandomNumberGenerator.next(0 to (possibleStarColours.size-1)))
}
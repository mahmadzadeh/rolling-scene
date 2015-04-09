package com.ui.rollingscene

import java.awt.{Point, Color}
import java.awt.Color._
import com.util.random.{Randomness, RandomNumberGenerator, RandomBoolean}

case class WhiteDisplayRectangle(x: Int, y: Int, width: Int, height: Int)
    extends DisplayRectangle(x, y, width, height) {
    override val color: Color =  WHITE

    def moveTo(loc:Point):WhiteDisplayRectangle = WhiteDisplayRectangle(x + ( loc.x - x) , y, width, height)
}
case class GreenDisplayRectangle(x: Int, y: Int, width: Int, height: Int)
    extends DisplayRectangle(x, y, width, height) {
    override val color: Color =  new Color (0, Randomness.next(10 to 246), 0)

    def moveTo(loc:Point):GreenDisplayRectangle = GreenDisplayRectangle(x + ( loc.x - x) , y, width, height)
}

package com.ui.rollingscene

import java.awt.{Point, Color}
import java.awt.Color._
import com.util.random.RandomBoolean

case class WhiteDisplayRectangle(x: Int, y: Int, width: Int, height: Int)
    extends DisplayRectangle(x, y, width, height) {
    override val color: Color =  WHITE

    def moveTo(loc:Point):WhiteDisplayRectangle = WhiteDisplayRectangle(x + ( loc.x - x) , y, width, height)
}
case class BlueDisplayRectangle(x: Int, y: Int, width: Int, height: Int)
    extends DisplayRectangle(x, y, width, height) {
    override val color: Color =  BLUE

    def moveTo(loc:Point):BlueDisplayRectangle = BlueDisplayRectangle(x + ( loc.x - x) , y, width, height)
}

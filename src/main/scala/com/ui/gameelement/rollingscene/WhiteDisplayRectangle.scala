package com.ui.gameelement.rollingscene

import java.awt.Color
import java.awt.Color._
import com.util.random.RandomBoolean

case class WhiteDisplayRectangle(x: Int, y: Int, width: Int, height: Int)
    extends DisplayRectangle(x, y, width, height) {
    override val color: Color = if(new RandomBoolean().nextRandomTrueWithOneOutOfNChance(10)) WHITE else BLUE
}

package com.ui.gameelement.rollingscene

import java.awt.{Graphics, Color, Rectangle}

object DisplayRectangle {
    val DEFAULT_ELEMENT_WIDTH  = 2
    // PIXELS
    val DEFAULT_ELEMENT_HEIGHT = 2

    def xOffset(x: Int, xOffset: Double): Int = x + (xOffset * DisplayRectangle.DEFAULT_ELEMENT_WIDTH).toInt

    def yOffset(y: Int, yOffset: Double): Int = y + (yOffset * DisplayRectangle.DEFAULT_ELEMENT_HEIGHT).toInt
}

abstract class DisplayRectangle(
                                   posX: Int,
                                   posY: Int,
                                   width: Int = DisplayRectangle.DEFAULT_ELEMENT_WIDTH,
                                   height: Int = DisplayRectangle.DEFAULT_ELEMENT_HEIGHT) {

    val color: Color

    val boundingBox: Rectangle = new Rectangle(posX, posY, width, height)

    def draw(g:Graphics):Unit = {
        g.setColor(color)
        g.drawRect(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height)
    }
}
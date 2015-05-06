package com.ui.rollingscene

import java.awt.Point

case class Velocity(velX: Int, velY: Int, deltaT: Int = 1) {

    def x1(x0:Int):Int = calculateNewPosition(velX, x0)

    def y1(y0:Int):Int = calculateNewPosition(velY, y0)

    def move(point: Point) = new Point(x1(point.x), y1(point.y))

    def increaseInX:Velocity = Velocity(velX + 1, velY, deltaT)

    def decreaseInX:Velocity = Velocity(velX - 1, velY, deltaT)

    def increaseInY:Velocity = Velocity(velX, velY + 1, deltaT)

    def decreaseInY:Velocity = Velocity(velX, velY - 1, deltaT)

    private def calculateNewPosition(velocity:Int , initialPos:Int ) = (velocity * deltaT) + initialPos
}


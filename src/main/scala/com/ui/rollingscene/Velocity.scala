package com.ui.rollingscene


trait Velocity {

    val vx:Int

    val vy:Int

    val dt:Int

    def x1(x0:Int):Int = calculateNewPosition(vx, x0)

    def y1(y0:Int):Int = calculateNewPosition(vy, y0)

    private def calculateNewPosition(velocity:Int , initialPos:Int ) = (velocity * dt) + initialPos
}


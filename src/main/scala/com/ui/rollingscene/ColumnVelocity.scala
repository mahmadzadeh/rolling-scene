package com.ui.rollingscene


case class ColumnVelocity(velX:Int= -1, velY:Int = 0, deltaT:Int = 1) extends Velocity {

    override val dt: Int = deltaT
    override val vx : Int = velX
    override val vy : Int = velY

}


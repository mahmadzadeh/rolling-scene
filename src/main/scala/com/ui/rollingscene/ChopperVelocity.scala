package com.ui.rollingscene

case class ChopperVelocity(velX: Int, velY: Int, deltaT: Int = 1) extends Velocity {

    override val dt: Int = deltaT
    override val vx: Int = velX
    override val vy: Int = velY

}


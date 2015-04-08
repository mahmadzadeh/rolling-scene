package com.ui.rollingscene

import java.util.Random

sealed trait HillSlope {
    private val rnd  = new Random()
    val slope:Int
    def oppositeSlope:HillSlope
    def randomHeightAddition:Int = 1 + Math.abs(rnd.nextInt() % 2)
}

object NegativeSlope extends HillSlope {
    val slope:Int = +1
    override def oppositeSlope: HillSlope = PositiveSlope
}

object PositiveSlope extends HillSlope {
    val slope:Int = -1
    override def oppositeSlope: HillSlope = NegativeSlope
}

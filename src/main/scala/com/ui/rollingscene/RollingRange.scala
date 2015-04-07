package com.ui.rollingscene

import com.util.random.{RandomBoolean, RandomNumberGenerator}
import java.util.Random

object RollingRange{
    private[this] val random = new RandomNumberGenerator()

    private[this] var curr:Int = random.next(0.to(200))

    def getNextRandomPoint(displayWindow:DisplayWindow):Int = {

        var hilSlope = RandomHillSlopeChange.changeHillSlopeWithProbability

        if(curr >= displayWindow.h)  hilSlope = PositiveSlope
        else if(curr <= displayWindow.h/2 ) hilSlope = NegativeSlope


        curr = Math.abs(curr + (hilSlope.dir * hilSlope.addition))

        curr
    }
}

sealed trait HillSlope {
    private val rnd  = new Random()
    val dir:Int
    def oppositeSlope:HillSlope
    def addition:Int = 1 + Math.abs(rnd.nextInt() % 2)
}
object PositiveSlope extends HillSlope {
    val dir:Int = +1
    override def oppositeSlope: HillSlope = NegativeSlope
}
object NegativeSlope extends HillSlope {
    val dir:Int = -1
    override def oppositeSlope: HillSlope = PositiveSlope
}

object RandomHillSlopeChange {
   private val rnd  = new Random()
   private var currentHillSlope:HillSlope = if(rnd.nextBoolean()) NegativeSlope else PositiveSlope

   def changeHillSlopeWithProbability: HillSlope = {
       val shouldChange =  Math.abs(rnd.nextInt() % 10)
       if(shouldChange > 8) {
           currentHillSlope = currentHillSlope.oppositeSlope
       }
       currentHillSlope
    }

}


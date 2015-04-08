package com.ui.rollingscene

import java.util.Random

object RandomHillSlopeChange {
   private[this] val rnd  = new Random()
   private[this] var currentHillSlope:HillSlope = if(rnd.nextBoolean()) NegativeSlope else PositiveSlope

   def changeHillSlopeWithProbability: HillSlope = {
       val shouldChange =  Math.abs(rnd.nextInt() % 10)

       if(shouldChange > 8)
           currentHillSlope = currentHillSlope.oppositeSlope

       currentHillSlope
    }
}

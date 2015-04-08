package com.ui.rollingscene


object RollingRange {
    private[this] var currMaxHeight:Option[Int] = None


    def getNextRandomPoint(displayWindow: DisplayWindow): Int = {

        val maxHillHeight: Int = displayWindow.h / 2

        currMaxHeight = currMaxHeight  match {
            case Some(currValue) =>
                var hilSlope = RandomHillSlopeChange.changeHillSlopeWithProbability
                if (currValue >= displayWindow.h) hilSlope = PositiveSlope
                else  if (currValue <= maxHillHeight) hilSlope = NegativeSlope
                Some(Math.abs(currValue + (hilSlope.slope * hilSlope.randomHeightAddition)))
            case None  => Some(displayWindow.h)
        }

        currMaxHeight.get
   }

}
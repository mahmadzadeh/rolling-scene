package com.ui.rollingscene

object RollingRange{
    private[this] var i = 0

    def getRange(displayWin:DisplayWindow):Range = (nextLowValue(displayWin).to(nextTopValue(displayWin)))

    def nextTopValue(displayWin:DisplayWindow):Int = {
        val h: Int = displayWin.h
        val scalingFactor = if(h >=0 && h <= 10 ) 10 else if (h >10 && h<=100) 100 else if (h > 100 && h <= 200) 200 else 10000

        this.i += 1

        if(i>360) this.i = 0

        val halfPoint  = (h / 2).toInt
        val sineBetweenZeroAndScalingFactor = Math.abs((Math.sin(i) * scalingFactor)).toInt
        if(sineBetweenZeroAndScalingFactor < halfPoint) halfPoint + sineBetweenZeroAndScalingFactor
        else sineBetweenZeroAndScalingFactor
    }

    def nextLowValue(displayWin: DisplayWindow):Int = {
        val h: Int = (displayWin.h / 2).toInt

        val scalingFactor = if(h >=0 && h <= 10 ) 10 else if (h >10 && h<=100) 100 else if (h > 100 && h <= 200) 200 else 10000

        this.i += 1

        if(i>360) this.i = 0

        val halfPoint  = (h / 2).toInt
        val sineBetweenZeroAndScalingFactor = Math.abs((Math.cos(i) * scalingFactor)).toInt
        if(sineBetweenZeroAndScalingFactor < halfPoint) halfPoint + sineBetweenZeroAndScalingFactor
        else sineBetweenZeroAndScalingFactor

    }
}

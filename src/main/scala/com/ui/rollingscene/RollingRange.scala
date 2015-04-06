package com.ui.rollingscene

object RollingRange{
    var i = 0

    def getRange(pixels:Int):Range = {
        i += 1
        val min = Math.abs(3*Math.sin(i) -  (pixels/5)).toInt
        val max = Math.abs(3*Math.cos(i) -  ((3*pixels)/5)).toInt

        return min.to(max)
    }
}

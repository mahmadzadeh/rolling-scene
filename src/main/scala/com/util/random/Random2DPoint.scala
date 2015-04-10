package com.util.random

import java.awt.Point

object Random2DPoint {

    def nextPoint(xRange:Range , yRange :Range):Point = {
        require(xRange !=null && yRange !=null )

        new Point(RandomNumberGenerator.next(xRange), RandomNumberGenerator.next(yRange))

    }
}

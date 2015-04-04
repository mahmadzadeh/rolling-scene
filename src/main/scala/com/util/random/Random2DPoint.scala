package com.util.random

import java.awt.Point

class Random2DPoint(xRange:Range , yRange :Range,
                    randomNumberGenerator:RandomNumberGenerator = new RandomNumberGenerator ) {
    require(xRange !=null && yRange !=null )

    def nextPoint:Point =
        new Point(randomNumberGenerator.next(xRange), randomNumberGenerator.next(yRange))
}

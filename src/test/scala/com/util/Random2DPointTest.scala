package com.util


import org.scalatest.FunSuite
import com.util.random.Random2DPoint

class Random2DPointTest extends FunSuite {

    test("require both x range and y range to create instance") {
        intercept[IllegalArgumentException] {
            new Random2DPoint(null,null)
        }
    }

    test("2D point returned is within the bounds of ranges") {
        val xRange = 0 to 200
        val yRange = -100 to 0

        val point = new Random2DPoint(xRange ,yRange).nextPoint

        assert(xRange.contains(point.x))
        assert(yRange.contains(point.y))
    }

    test("ranges") {
        val xRange = 0 to 1200
        val yRange = 0 to 500

        val dp = new Random2DPoint(xRange ,yRange)

       for( p <- 0 to 10 ) {
           val point = dp.nextPoint
           assert(xRange.contains(point.x))
           assert(yRange.contains(point.y))
       }
    }
}

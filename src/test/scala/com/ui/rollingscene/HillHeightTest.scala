package com.ui.rollingscene

import org.scalatest.FunSuite


class HillHeightTest extends FunSuite {

    val display  = DisplayWindow(100,200)
    val sceneCov = ScreenCoverage(display,100)

    test("given Hillheight then call to nextRandomPoint returns a point within the display window") {
        val n = 100

        val vals = 0 to 360 map { i=>
            HillHeight.nextRandomPointOnHill(display)
        }

        vals.forall( _ < display.h)
    }

}


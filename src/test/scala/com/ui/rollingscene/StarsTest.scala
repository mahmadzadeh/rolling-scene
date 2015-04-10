package com.ui.rollingscene

import org.scalatest.FunSuite

class StarsTest extends FunSuite {

    val displayWindow = DisplayWindow(100,100)
    test("given stars then calling get shining stars will draw the part of the stars in the sky") {

        val shiningStars = Stars.shiningStars(displayWindow)

        assert(shiningStars.size == Stars.STAR_COUNT /2 )
    }

}





package com.ui.rollingscene

import org.scalatest.FunSuite

class StarsTest extends FunSuite {

    val displayWindow = DisplayWindow(100,100)
    test("given stars object the star clusters get initialized once ") {

        val shiningStars = Stars.shiningStars(displayWindow)

        assert(shiningStars.size == Stars.STAR_COUNT )
    }

    test("given stars then calling get shining stars multiple times always will always return stars") {
        0 to 10 foreach { i=>
            assert(Stars.STAR_COUNT == Stars.shiningStars(displayWindow).size)
        }
    }

}





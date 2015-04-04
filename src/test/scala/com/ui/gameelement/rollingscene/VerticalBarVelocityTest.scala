package com.ui.gameelement.rollingscene

import org.scalatest.FunSuite

class VerticalBarVelocityTest extends FunSuite {

    test("given default velocity then x1() returns the new location on X axis based on given default velocity") {
        val vel = VerticalBarVelocity()

        assert( 1 === vel.x1(0) )

    }

    test("given default velocity of +2 px/time_unit then x1() returns the new location on X axis based on given default velocity") {
        val vel = VerticalBarVelocity(2,0,1)

        assert(2 === vel.x1(0) )
    }

}

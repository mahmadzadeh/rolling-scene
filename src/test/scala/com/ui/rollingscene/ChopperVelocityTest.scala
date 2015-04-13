package com.ui.rollingscene

import org.scalatest.FunSuite
import java.awt.Point

class ChopperVelocityTest extends FunSuite {

    test("given chopper velocity then increase velocity in X will return new velocity") {
        val v = ChopperVelocity(1,1).increaseInX

        assert(2 === v.vx)
    }

    test("given chopper velocity then increase velocity in y will return new velocity") {
        val v = ChopperVelocity(1,1).increaseInY

        assert(2 === v.vy)
    }

    test("given chopper velocity then transfer point will move a given to based on current velocity") {
        val point = ChopperVelocity(2,2).move(new Point)

        assert(2 === point.x)
        assert(2 === point.y)
    }

    test("given chopper with negative velocity then transfer point will move a given to based on current velocity") {
        val point = ChopperVelocity(-2,-2).move(new Point)

        assert(-2 === point.x)
        assert(-2 === point.y)
    }

}

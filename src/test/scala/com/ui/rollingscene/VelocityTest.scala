package com.ui.rollingscene

import org.scalatest.FunSuite
import java.awt.Point

class VelocityTest extends FunSuite {

    test("given default velocity of +2 px/time_unit then x1() returns the new location on X axis based on given default velocity") {
        val vel = Velocity(2,0,1)

        assert(2 === vel.x1(0) )
    }

    test("given velocity of 2 px/sec in X then call next point returns the new position from current position") {
        val testVel = Velocity(2,0, 1)

        assertResult(2) {
            testVel.x1(0)
        }
    }

    test("given velocity of -2 px/sec in X then call next point returns the new vx ") {
        val testVel = Velocity(-2,0, 1)

        assertResult(-2) {
            testVel.x1(0)
        }
    }

    test("given velocity of 0 px/sec in X then call next point returns vx (same as before)") {
        val testVel = Velocity(0,0, 1)

        assertResult(1) {
            testVel.x1(1)
        }
    }
    test("given chopper velocity then increase velocity in X will return new velocity") {
        val v = Velocity(1,1).increaseInX

        assert(2 === v.velX)
    }

    test("given chopper velocity then increase velocity in y will return new velocity") {
        val v = Velocity(1,1).increaseInY

        assert(2 === v.velY)
    }

    test("given chopper velocity then transfer point will move a given to based on current velocity") {
        val point = Velocity(2,2).move(new Point)

        assert(2 === point.x)
        assert(2 === point.y)
    }

    test("given chopper with negative velocity then transfer point will move a given to based on current velocity") {
        val point = Velocity(-2,-2).move(new Point)

        assert(-2 === point.x)
        assert(-2 === point.y)
    }



}


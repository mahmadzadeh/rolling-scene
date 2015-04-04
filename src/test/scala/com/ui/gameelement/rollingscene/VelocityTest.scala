package com.ui.gameelement.rollingscene

import org.scalatest.FunSuite
import java.awt.Point

class VelocityTest extends FunSuite {


    test("given velocity of 2 px/sec in X then call next point returns the new position from current position") {
        val testVel = new TestVelocity(2,0, 1)

        assertResult(2) {
            testVel.x1(0)
        }
    }

    test("given velocity of -2 px/sec in X then call next point returns the new vx ") {
        val testVel = new TestVelocity(-2,0, 1)

        assertResult(-2) {
            testVel.x1(0)
        }
    }

    test("given velocity of 0 px/sec in X then call next point returns vx (same as before)") {
        val testVel = new TestVelocity(0,0, 1)

        assertResult(1) {
            testVel.x1(1)
        }
    }

    class TestVelocity(velX:Int, velY:Int, deltaT:Int ) extends Velocity{
        override val dt: Int = deltaT
        override val vx : Int = velX
        override val vy : Int = velY
    }
}


package com.ui.rollingscene

import org.scalatest.FunSuite
import java.awt.Point

class ChopperTest extends FunSuite  {
    val zeroVelocity    = Velocity(0,0)

    val imageCache      = new ImageCache
    val images          = List(imageCache.load("/cobra_0.jpg").get, imageCache.load("/cobra_1.jpg").get)
    val point           = new Point
    val chopperVelocity = Velocity(1, 1)
    val displayWindow   = DisplayWindow(100,100)

    val testChopper     = new Chopper(point, chopperVelocity, images, displayWindow)

    test("given point and velocity then a chopper can be created") {
        new Chopper(point, chopperVelocity, Nil, displayWindow)
    }

    test("given a chopper then bounding box returns the bounding box around the chopper") {

        val bbox = testChopper.boundingBox
        assert(point.x === bbox.x)
        assert(point.y === bbox.y)
        assert(testChopper.chopperImages.head.getWidth === bbox.width)
    }

    test("given a chopper zero when moved will return the next chopper  ") {
        assert(testChopper.move.isInstanceOf[Chopper])
    }

    test("given a chopper then calling increaseSpeedInX will increase the chopper's speed in X axis") {
        val fasterChopper = testChopper.moveForward
        assert(chopperVelocity.velX + 1 === fasterChopper.velocity.velX)

    }

    test("given a chopper then calling increaseSpeedInY will increase the chopper's speed in Y axis") {
        val chopperMovingDown = testChopper.moveDown
        assert(chopperVelocity.velY + 1 === chopperMovingDown.velocity.velY)
    }

    test("given a chopper with velocity of 0 then call to move will not really move the chopper") {
        assert(point === Chopper(point, zeroVelocity, images, displayWindow).move.topLeft)
    }
 
    test("given a chopper at the right edge of the screen then move will not updated the location of the chopper") {

        val rightEdgeOfScreen: Point = new Point(displayWindow.w - testChopper.boundingBox.x, point.y)

        val myChopper = new Chopper(point, Velocity(1,0), images, displayWindow).moveTo(rightEdgeOfScreen)

        assert(rightEdgeOfScreen === myChopper.move.topLeft)
    }

    test("given a chopper at the left edge of the screen then move will not updated the location of the chopper") {

        val leftEdgeOfScreen: Point = new Point(0, 0)

        val myChopper = new Chopper(point, Velocity(-1,0), images, displayWindow).moveTo(leftEdgeOfScreen)

        assert(leftEdgeOfScreen === myChopper.move.topLeft)
    }

}

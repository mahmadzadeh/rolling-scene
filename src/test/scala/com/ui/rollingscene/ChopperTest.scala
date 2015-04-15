package com.ui.rollingscene

import org.scalatest.FunSuite
import java.awt.Point

class ChopperTest extends ImageCacheDependantTest {

    val chopperVelocity = ChopperVelocity(1, 1)
    val point           = new Point
    val images          = List(ImageCache.load("/cobra_0.jpg").get, ImageCache.load("/cobra_1.jpg").get)

    test("given point and velocity then a chopper can be created") {
        val chpr = new Chopper(point, chopperVelocity, Nil)
    }

    test("given a chopper then bounding box returns the bounding box around the chopper") {
        val chpr = new Chopper(point, chopperVelocity, images)

        val bbox = chpr.boundingBox

        assert(point.x === bbox.x)
        assert(point.y === bbox.y)
        assert(chpr.chopperImages.head.getWidth === bbox.width)
    }

    test("given a chopper zero when moved will return the next chopper  ") {

        assert(new Chopper(point, chopperVelocity, images).move.isInstanceOf[Chopper])
    }

    test("given a chopper then calling increaseSpeedInX will increase the chopper's speed in X axis") {

        val fasterChopper = new Chopper(point, chopperVelocity, images).increaseSpeedInX

        assert(chopperVelocity.velX + 1 === fasterChopper.velocity.velX)

    }

    test("given a chopper then calling increaseSpeedInY will increase the chopper's speed in Y axis") {

        val fasterChopper = new Chopper(point, chopperVelocity, images).increaseSpeedInY

        assert(chopperVelocity.velY + 1 === fasterChopper.velocity.velY)
    }


    test("given a chopper with velocity of 0 then call to move will not really move the chopper") {

        val myChopper = new Chopper(point, ChopperVelocity(0,0), images)

        assert(point === myChopper.move.topLeft)
    }

}

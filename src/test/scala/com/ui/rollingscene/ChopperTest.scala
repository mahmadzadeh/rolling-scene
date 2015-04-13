package com.ui.rollingscene

import org.scalatest.FunSuite
import java.awt.Point

class ChopperTest extends FunSuite {
    val chopperVelocity = ChopperVelocity(1, 1)
    val point           = new Point

    test("given point and velocity then a chopper can be created") {
        val chpr = new ChopperZero(point, chopperVelocity)
    }

    test("given a chopper then bounding box returns the bounding box around the chopper") {
        val chpr = new ChopperZero(point, chopperVelocity)

        val bbox = chpr.boundingBox

        assert(point.x === bbox.x)
        assert(point.y === bbox.y)
        assert(chpr.image.getWidth === bbox.width)
    }

    test("given a chopper zero when moved will return the next chopper  ") {
        val chpr = new ChopperZero(point, chopperVelocity)

        assert(chpr.move.isInstanceOf[ChopperOne])
    }

}

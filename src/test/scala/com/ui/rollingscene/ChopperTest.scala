package com.ui.rollingscene

import org.scalatest.FunSuite
import java.awt.Point

class ChopperTest extends FunSuite {
    val chopperVelocity   = ChopperVelocity(1, 1)
    val point              = new Point

    test("given point and velocity then a chopper can be created") {
        val chpr = new Chopper(point, chopperVelocity )
    }

    test("given a chopper then boudingbox returns the bounding box around the chopper") {

        val chpr = new Chopper(point,chopperVelocity )

        val bbox = chpr.boundingBox

        assert(point.x === bbox.x)
        assert(point.y === bbox.y)
        assert(chpr.image.getWidth === bbox.width)
    }

}

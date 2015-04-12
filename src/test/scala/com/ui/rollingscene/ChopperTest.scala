package com.ui.rollingscene

import org.scalatest.FunSuite
import java.awt.Point

class ChopperTest extends FunSuite {

    test("given point and velocity then a chopper can be created") {
        val chpr = new Chopper(new Point, ChopperVelocity(1,1) )
    }



}

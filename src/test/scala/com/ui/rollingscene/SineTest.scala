package com.ui.rollingscene

import org.scalatest.FunSuite
import scala.collection.immutable.Queue


class SineTest extends FunSuite {

    val display = DisplayWindow(100,200)

    test("given a sine class then call to nextTopValue returns the next value for the top range") {
        val n = 100

        val v = RollingRange.nextTopValue(display)

        val vals = 0 to 360 map { i=>
            RollingRange.nextTopValue(display)
        }

        println(vals)
        assert(vals.forall( _ >=  (display.h/2)))
    }

    test("given a cos then call to nextLowValue returns the next value for the bottom range") {
        val n = 100

        val vals = 0 to 360 map { i=>
            RollingRange.nextLowValue(display)
        }

        assert(vals.forall( _ <=  (display.h/2)))
    }

    test("given RollingRange then call to getRange returns a range that's within window range ") {
        val n = 100

        val vals = 0 to 360 map { i=>
            RollingRange.getRange(display)
        }

        assert(vals.forall( _.min <=  (display.h/2)))
        assert(vals.forall( _.max >=  (display.h/2)))
    }
}


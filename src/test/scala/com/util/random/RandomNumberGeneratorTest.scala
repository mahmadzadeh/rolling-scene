package com.util.random

import org.scalatest.FunSuite


class RandomNumberGeneratorTest extends FunSuite {

    test("getting a random number in a range") {
        val range = 0 to 10
        val rand = new RandomNumberGenerator

        assert(rand.next(range).isInstanceOf[Int])
    }
}

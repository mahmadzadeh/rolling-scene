package com.util.random

import org.scalatest.FunSuite


class RandomNumberGeneratorTest extends FunSuite {

    test("given a range then next will return a random number in the range") {
        val range = 0 to 10

        val next: Int = RandomNumberGenerator.next(range)

        assert(next.isInstanceOf[Int])
        assert(range.min <= next && next <= range.max)
    }

    test("given a rng then call to getNRandom will return n random number in the range") {
        val range = 0 to 10
        val n     = 10

        val randomNumbers = RandomNumberGenerator.nextNNumbers(n, range)

        assert(n == randomNumbers.size)

        assert(randomNumbers.forall {i=> range.min <= i && i<=range.max  })
    }


}

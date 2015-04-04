package com.util.random

import org.scalatest.FunSuite

class RandomBooleanTest extends FunSuite {

    val end: Int = 100

    test("given a random boolean generator then can generate random boolean values") {
        val rand = new RandomBoolean

        val vals = 1.to(end).map { i =>
            rand.nextRandomTrueWithOneOutOfNChance(2)
        }

        assertResult(end){
            vals.filter(_ ==true).size+vals.filter( _ ==false).size
        }
    }
}

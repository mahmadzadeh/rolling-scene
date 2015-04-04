package com.util.random


class RandomBoolean(randomNumberGenerator:RandomNumberGenerator = new RandomNumberGenerator) {

    def nextRandomTrueWithOneOutOfNChance(n:Int): Boolean =
        randomNumberGenerator.next(1 to n) == 1
    
}

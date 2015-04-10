package com.util.random


object RandomBoolean {

    def nextRandomTrueWithOneOutOfNChance(n:Int): Boolean =
        RandomNumberGenerator.next(1 to n) == 1
    
}

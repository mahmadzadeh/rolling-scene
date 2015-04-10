package com.util.random

import java.util.Random
import scala.collection.immutable.Range.Inclusive

object RandomNumberGenerator {


    val random: Random = new Random()

    def next(range: Range): Int = {
        random.nextInt(range.max - range.min + 1) + range.min
    }

    def nextNNumbers(n:Int , range: Range):Seq[Int] = List.tabulate(n) {i=> next(range)}

}


package com.util.random

import java.util.Random

class RandomNumberGenerator(val random: Random = new Random()) {

    def next(range: Range): Int = {
        random.nextInt(range.max - range.min + 1) + range.min
    }

}


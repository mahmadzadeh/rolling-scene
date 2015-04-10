package com.ui.rollingscene

import com.util.random.Random2DPoint

object Stars {
    val STAR_COUNT = 20

    private[this] var stars:Seq[Star] = Nil
    private val shouldInitializeStars: Boolean = stars == Nil

    def shiningStars(display:DisplayWindow):Seq[Star] = {
        if(shouldInitializeStars)
            stars = List.tabulate(STAR_COUNT ) { i:Int => createOneRandomStar(display)}

        scala.util.Random.shuffle(stars).take(STAR_COUNT/ 2)
    }


    private def createOneRandomStar(display:DisplayWindow):Star =
        Star(Random2DPoint.nextPoint(0 to display.w, 0 to display.h))

}

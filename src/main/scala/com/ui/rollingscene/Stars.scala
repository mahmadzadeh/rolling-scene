package com.ui.rollingscene

import com.util.random.Random2DPoint

object Stars {
    val STAR_COUNT = 500
    val STAR_CLUSTER_COUNT = 3

    private var starClusters:Seq[Seq[Star]]= Nil

    def shiningStars(display:DisplayWindow):Seq[Star] = {
        if(shouldInitializeStars)
            initializeStars(display)

        if(StarClusterTimer.isTime(System.currentTimeMillis()))
            starClusters = starClusters.tail :+ starClusters.head

        starClusters.head
    }

    private def initializeStars(display: DisplayWindow):Unit =
        starClusters = List.tabulate(STAR_CLUSTER_COUNT) {
            i: Int => List.tabulate(STAR_COUNT) {
                k: Int => createOneRandomStar(display)
            }
        }

    private def shouldInitializeStars: Boolean = starClusters == Nil

    private def createOneRandomStar(display:DisplayWindow):Star =
        Star(Random2DPoint.nextPoint(0 to display.w, 0 to display.h))

}

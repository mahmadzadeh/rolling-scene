package com.ui.rollingscene

import scala.collection.immutable.Queue
import java.awt.{Point, Graphics}

case class Hills(colQueue: Queue[HillColumn] = Queue.empty,
                 sceneCoverage: RollingSceneCoverage,
                 velocity: Velocity = Velocity(-1,0 )) {

    /**
     * adds enough bars to fill the screen on the left side of the screen
     * @return
     */
    def add: Hills =
        if (!colQueue.isEmpty) {
            Hills(colQueue.enqueue(createRequiredColumns), sceneCoverage, velocity).removeOffScreen
        } else {
            val veryFirstBar = ColumnFactory.create(sceneCoverage.firstBar, sceneCoverage)
            Hills(colQueue.enqueue(veryFirstBar), sceneCoverage, velocity)
        }

    def createRequiredColumns: List[HillColumn] =
        ColumnFactory.fillScreen(colQueue.last.nextColumnToRight, sceneCoverage).toList

    def count: Int = colQueue.size

    def draw(g: Graphics): Unit = colQueue.foreach(_.draw(g))

    def removeOffScreen: Hills = {
        Hills(colQueue.filter(_.topLeft.x > 0), sceneCoverage, velocity)
    }

    def move: Hills =
        Hills(colQueue.map(_.move(sceneCoverage, velocity)), sceneCoverage, velocity)

    def columnPositions: Seq[Point] =
        colQueue.collect {
            case bar => bar.topLeft
        }.toList

}


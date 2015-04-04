package com.ui.rollingscene

import scala.collection.immutable.Queue
import java.awt.{Point, Graphics}

case class Columns(colQueue: Queue[Column] = Queue.empty,
                        sceneCoverage: RollingSceneCoverage,
                        velocity: Velocity = ColumnVelocity()) {

    /**
     * adds enough bars to fill the screen on the left side of the screen
     * @return
     */
    def add: Columns =
        if (!colQueue.isEmpty){
            Columns(colQueue.enqueue(createRequiredColumns), sceneCoverage,velocity).removeOffScreen
        } else {
            val veryFirstBar = ColumnFactory.create(sceneCoverage.firstBar, sceneCoverage)
            Columns(colQueue.enqueue(veryFirstBar), sceneCoverage,velocity)
        }


    def createRequiredColumns: List[Column] = {
        ColumnFactory.createFillScreen(colQueue.last.nextColumnToRight, sceneCoverage).toList
    }

    def count: Int = colQueue.size

    def draw(g: Graphics): Unit = colQueue.foreach(_.draw(g))

    def removeOffScreen: Columns = {
        Columns(colQueue.filter(_.topLeft.x > 0), sceneCoverage, velocity)
    }

    def move: Columns =
        Columns(colQueue.map(_.move(sceneCoverage, velocity)), sceneCoverage, velocity)

    def columnPositions: Seq[Point] =
        colQueue.collect {
            case bar => bar.topLeft
        }.toList

}


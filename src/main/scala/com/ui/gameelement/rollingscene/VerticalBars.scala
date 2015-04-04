package com.ui.gameelement.rollingscene

import scala.collection.immutable.Queue
import java.awt.{Point, Graphics}

case class VerticalBars(bars: Queue[VerticalBar] = Queue.empty,
                        sceneCoverage: RollingSceneCoverage,
                        velocity: Velocity = VerticalBarVelocity()) {

    def add: VerticalBars =
        if (!bars.isEmpty){
            VerticalBars(bars.enqueue(createBarsRequired), sceneCoverage,velocity).removeOffScreen
        } else {
            val veryFirstBar = OneVerticalBarFactory.create(sceneCoverage.firstBar, sceneCoverage)
            VerticalBars(Queue.empty.enqueue(veryFirstBar), sceneCoverage,velocity)
        }


    def createBarsRequired: List[VerticalBar] = {
        OneVerticalBarFactory.createFillScreen(bars.last.nextBarTopLeft, sceneCoverage).toList
    }

    def count: Int = bars.size

    def draw(g: Graphics): Unit = bars.foreach(_.draw(g))

    def removeOffScreen: VerticalBars = {
        VerticalBars(bars.filter(_.topLeft.x > 0), sceneCoverage, velocity)
    }

    def move: VerticalBars =
        VerticalBars(bars.map(_.move(sceneCoverage, velocity)), sceneCoverage, velocity)

    def barPositions: Seq[Point] =
        bars.collect {
            case bar => bar.topLeft
        }.toList

}


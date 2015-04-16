package com.ui.rollingscene

import java.awt.Graphics


case class RollingScene(hills: Hills, chopper:Chopper) {

    def refresh:RollingScene = {
        new RollingScene(hills.move.add, chopper.move)
    }

    def draw(g:Graphics):Unit = {
        Stars.shiningStars(hills.sceneCoverage.displayWindow).foreach(_.draw(g))
        hills.draw(g)
        chopper.draw(g)
    }

    def increaseSpeedInX:RollingScene = RollingScene(hills, chopper.increaseSpeedInX)

}

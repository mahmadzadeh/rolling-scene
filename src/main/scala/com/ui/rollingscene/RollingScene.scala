package com.ui.rollingscene

import java.awt.Graphics


case class RollingScene(verticalBars: Hills) {

    def refresh:RollingScene = {
        new RollingScene(verticalBars.move.add)
    }

    def draw(g:Graphics):Unit = {
        Stars.shiningStars(verticalBars.sceneCoverage.displayWindow).foreach(_.draw(g))
        verticalBars.draw(g)
    }

}

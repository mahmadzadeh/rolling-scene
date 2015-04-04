package com.ui.rollingscene

import java.awt.Graphics


case class RollingScene(verticalBars: VerticalBars) {

    def refresh:RollingScene = {
        new RollingScene(verticalBars.move.add)
    }

    def draw(g:Graphics):Unit = verticalBars.draw(g)

}

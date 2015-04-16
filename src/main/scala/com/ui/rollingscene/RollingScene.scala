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

    def increaseChopperSpeed:RollingScene = RollingScene(hills, chopper.moveForward)
    
    def decreaseChopperSpeed:RollingScene = RollingScene(hills, chopper.moveBackward)

    def moveChopperDown:RollingScene = RollingScene(hills, chopper.moveDown)

    def moveChopperUp:RollingScene = RollingScene(hills, chopper.moveUp)

}

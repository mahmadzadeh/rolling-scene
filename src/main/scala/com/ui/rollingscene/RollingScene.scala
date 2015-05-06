package com.ui.rollingscene

import java.awt.{Color, Font, Graphics}

import com.ui.rollingscene.Stars.shiningStars

case class RollingScene(hills: Hills, chopper: Chopper) {
    private[this] val findSize              = 18
    private[this] val instructionFont: Font = new Font("TimesRoman", Font.BOLD, findSize)


    def refresh: RollingScene = {
        new RollingScene(hills.move.add, chopper.move)
    }

    def draw(g: Graphics): Unit = {
        shiningStars(hills.sceneCoverage.displayWindow).foreach(_.draw(g))
        hills.draw(g)
        chopper.draw(g)
        displayArrowKeys(g, hills.sceneCoverage.displayWindow)
    }

    def increaseChopperSpeed: RollingScene = {
        val displayWindow = hills.sceneCoverage.displayWindow

        RollingScene(hills, chopper.moveForward)

    }

    def decreaseChopperSpeed: RollingScene = RollingScene(hills, chopper.moveBackward)

    def moveChopperDown: RollingScene = RollingScene(hills, chopper.moveDown)

    def moveChopperUp: RollingScene = RollingScene(hills, chopper.moveUp)

    private def displayArrowKeys(g:Graphics, displayWin:DisplayWindow):Unit = {
        val c = g.getColor        
        g.setFont(instructionFont)
        g.setColor(Color.WHITE)

        g.drawString(s"← ↑ ↓ →", 2, 30)
        g.drawString(s"vx: ${chopper.velocity.velX} vy: ${chopper.velocity.velY}", 2, 60)

        g.setColor(c)
    }

}

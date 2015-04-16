package com.ui.panel

import javax.swing.JPanel
import com.ui.rollingscene._
import java.awt.{Point, Color, Graphics}
import com.ui.rollingscene.Hills
import com.ui.rollingscene.DisplayWindow
import com.ui.rollingscene.RollingScene
import com.ui.rollingscene.RollingSceneCoverage
import scala.collection.immutable.Queue
import java.awt.event.{KeyAdapter, KeyEvent}

class RollingScenePanel extends JPanel with Runnable {

    private[this] var animator    : Thread       = _
    private[this] var rollingScene: RollingScene = _

    private val PREFERRED_WIDTH  = 700
    private val PREFERRED_HEIGHT = 300
    private val REFRESH_RATE     = 100

    private val chopperImages          = ChopperImages.imageList
    private val sceneVelocity          = Velocity(-2, 0, 1)
    private val initialChopperVelocity = Velocity(0, 0)

    setPanelAttributes

    repaint()

    override def paintComponent(g: Graphics): Unit = {
        super.paintComponent(g)

        val display = DisplayWindow(getWidth, getHeight)

        if (rollingScene == null) {

            val sceneCoverage = RollingSceneCoverage(display, 100)
            rollingScene = RollingScene(Hills(Queue.empty, sceneCoverage, sceneVelocity),
                new Chopper(new Point(75, 100), initialChopperVelocity, chopperImages)).refresh
        } else {
            rollingScene = rollingScene.refresh
        }

        rollingScene.draw(g)
    }

    override def addNotify: Unit = {
        super.addNotify()

        animator = new Thread(this)
        animator.start()
    }

    override def run(): Unit = gameLoop

    private def gameLoop: Unit =
        do {
            repaint()
            sleep(REFRESH_RATE)
        } while (true)


    private def sleep(sleepTime: Int) {
        try {
            Thread.sleep(sleepTime)
        } catch {
            case e: InterruptedException => println("Interrupted: " + e.getMessage())
        }
    }

    private class KeyBoardAdapter extends KeyAdapter {
        override def keyPressed(e: KeyEvent) {
            e.getKeyCode match {
                case KeyEvent.VK_SPACE =>
                    Unit
                case KeyEvent.VK_RIGHT =>
                    rollingScene = rollingScene.increaseChopperSpeed
                case KeyEvent.VK_LEFT =>
                    rollingScene = rollingScene.decreaseChopperSpeed
                case KeyEvent.VK_DOWN =>
                    rollingScene = rollingScene.moveChopperDown
                case KeyEvent.VK_UP =>
                    rollingScene = rollingScene.moveChopperUp
                case _ => Unit
            }
        }
    }

    private def setPanelAttributes {
        setDoubleBuffered(true)
        setBackground(Color.BLACK)

        val mainCanvasLayout = new org.jdesktop.layout.GroupLayout(this)
        setLayout(mainCanvasLayout)

        mainCanvasLayout
        .setHorizontalGroup(mainCanvasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(0, PREFERRED_WIDTH, java.lang.Short.MAX_VALUE))

        mainCanvasLayout
        .setVerticalGroup(mainCanvasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                          .add(0, PREFERRED_HEIGHT, java.lang.Short.MAX_VALUE))

        setFocusable(true)
        addKeyListener(new KeyBoardAdapter)
    }


}

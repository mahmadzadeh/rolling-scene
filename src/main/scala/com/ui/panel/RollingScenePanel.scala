package com.ui.panel

import javax.swing.JPanel
import com.ui.rollingscene._
import java.awt.{Point, Color, Graphics}
import com.ui.rollingscene.Hills
import com.ui.rollingscene.DisplayWindow
import com.ui.rollingscene.RollingScene
import com.ui.rollingscene.RollingSceneCoverage
import com.ui.rollingscene.ChopperZero
import scala.collection.immutable.Queue

class RollingScenePanel extends JPanel  with Runnable{
    private[this] var animator: Thread = null

    private[this] var rollingScene: RollingScene= _

    private val PREFERRED_WIDTH : Int = 700
    private val PREFERRED_HEIGHT: Int = 300

    setPanelAttributes

    repaint()

    override def paintComponent(g: Graphics): Unit = {
        super.paintComponent(g)

        val display = DisplayWindow(getWidth, getHeight)

        if(rollingScene == null) {
            val sceneCoverage = RollingSceneCoverage(display,100)
            rollingScene = RollingScene(Hills(Queue.empty, sceneCoverage,ColumnVelocity(-2,0,1)), new ChopperZero(new Point(75,100), ChopperVelocity(0,0))).refresh
        } else {
            rollingScene = rollingScene.refresh
        }

        rollingScene.draw(g)
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
    }

    override def run(): Unit = mainGameLoop

    private def mainGameLoop: Unit = {

        var beforeTime = System.currentTimeMillis()

        do {

            repaint()

            sleep(beforeTime)

            beforeTime = System.currentTimeMillis()

        } while (true)
    }

    private def sleep(beforeTime: Long) {
        try {
            Thread.sleep(100)
        } catch {
            case e: InterruptedException => println("Interrupted: " + e.getMessage())
        }
    }

    override def addNotify: Unit = {
        super.addNotify()

        animator = new Thread(this)
        animator.start()
    }
}

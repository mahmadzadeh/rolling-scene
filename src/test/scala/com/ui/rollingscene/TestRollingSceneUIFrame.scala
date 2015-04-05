package com.ui.rollingscene

import javax.swing.{JFrame, JPanel}
import java.awt._
import org.jdesktop.layout.GroupLayout
import scala.collection.immutable.Queue

class TestRollingSceneUIFrame extends JFrame {
    setResizable(false)

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

    initAllComponents
    pack()

    private def initAllComponents: Unit = {


        val panel = new TestRollingSceneUIPanel()

        val layout: GroupLayout = new GroupLayout(getContentPane)


        getContentPane.setLayout(layout)


        layout.setHorizontalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                  .add(layout.createSequentialGroup.addContainerGap()
                                       .add(panel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addContainerGap))

        layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup.add(0, 0, 0)
                                     .add(panel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                     .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 0, java.lang.Short.MAX_VALUE)))


    }
}

class TestRollingSceneUIPanel extends JPanel  with Runnable{
    private[this] var animator: Thread = null

    private[this] var rollingScene: RollingScene= _


    private val PREFERRED_WIDTH : Int = 300
    private val PREFERRED_HEIGHT: Int = 200

    setPanelAttributes

    repaint()

    override def paintComponent(g: Graphics): Unit = {
        super.paintComponent(g)
        val display = DisplayWindow(getWidth, getHeight)

        if(rollingScene == null) {
            val sceneCoverage = RollingSceneCoverage(display)
            rollingScene = RollingScene ( Columns(Queue.empty, sceneCoverage,ColumnVelocity(-2,0,1))).refresh
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


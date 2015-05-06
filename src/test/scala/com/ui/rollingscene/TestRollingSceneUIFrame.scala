package com.ui.rollingscene

import java.awt.{Color, Graphics, Point}
import javax.swing.{JFrame, JPanel}

import org.jdesktop.layout.GroupLayout

class TestRollingSceneUIFrame extends JFrame {
    private val chopperImages    = ChopperImages.imageList

    setResizable(false)

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

    initAllComponents
    pack()

    private def initAllComponents: Unit = {
        val panel = new TestRollingSceneUIPanel(new Chopper(new Point(10,10), Velocity(0,0), chopperImages, new DisplayWindow(100,100)))

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

class TestRollingSceneUIPanel (item:Chopper) extends JPanel {
    private val PREFERRED_WIDTH : Int = 300
    private val PREFERRED_HEIGHT: Int = 200

    setPanelAttributes

    repaint()

    override def paintComponent(g: Graphics): Unit = {
        super.paintComponent(g)
        item.draw(g)
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
}


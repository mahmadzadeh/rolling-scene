package com.ui.panel

import javax.swing.JFrame
import org.jdesktop.layout.GroupLayout

class RollingSceneFrame extends JFrame {
    setResizable(false)

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

    initAllComponents
    pack()

    private def initAllComponents: Unit = {


        val panel = new RollingScenePanel()

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




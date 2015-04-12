package com

import com.ui.panel.RollingSceneFrame

object Main extends App {
    override
    def main(args: Array[String]) :Unit =  {
        val frame = new RollingSceneFrame

        java.awt.EventQueue.invokeLater(new Runnable {
            def run {
                frame.setVisible(true)
            }
        })
    }
}

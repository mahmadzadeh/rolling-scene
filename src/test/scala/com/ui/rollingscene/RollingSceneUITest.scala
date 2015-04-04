package com.ui.rollingscene

object RollingSceneUITest extends App {
    override
    def main(args: Array[String]) :Unit =  {
        val frame = new TestRollingSceneUIFrame

        java.awt.EventQueue.invokeLater(new Runnable {
            def run {
                frame.setVisible(true)
            }
        })
    }
}

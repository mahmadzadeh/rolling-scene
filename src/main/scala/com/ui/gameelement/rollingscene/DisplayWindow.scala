package com.ui.gameelement.rollingscene

case class DisplayWindow(w: Int, h: Int) {
    require(w >= 0 && h >= 0)

    override def toString:String = s"W: ${w} H: ${h}"
}


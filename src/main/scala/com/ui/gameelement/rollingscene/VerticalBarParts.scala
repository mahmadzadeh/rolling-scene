package com.ui.gameelement.rollingscene

import com.ui.gameelement.rollingscene.DisplayRectangle

trait VerticalBarParts {
    def parts(x: Int, y: Int): List[DisplayRectangle] = List[DisplayRectangle]()
}

package com.ui.rollingscene

import org.scalatest.{BeforeAndAfterEach, FunSuite}

class ImageCacheDependantTest  extends FunSuite with BeforeAndAfterEach {

    override def beforeEach() {
        ImageCache.bust
    }

}

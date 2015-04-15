package com.ui.rollingscene

import java.awt.image.BufferedImage

object ChopperImages {

    def imageList:Seq[BufferedImage] = Seq(
                                  ImageCache.loadOrThrow("/cobra_0.jpg"),
                                  ImageCache.loadOrThrow("/cobra_1.jpg"),
                                  ImageCache.loadOrThrow("/cobra_2.jpg"),
                                  ImageCache.loadOrThrow("/cobra_3.jpg"))

    def possibleImageList:Seq[Option[BufferedImage]] =
        Seq(ImageCache.load("/cobra_0.jpg"), ImageCache.load("/cobra_1.jpg"),
            ImageCache.load("/cobra_2.jpg"), ImageCache.load("/cobra_3.jpg"))
}

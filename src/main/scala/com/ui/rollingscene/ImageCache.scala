package com.ui.rollingscene

import java.awt.image.BufferedImage
import scala.util.Try
import javax.imageio.ImageIO

object ImageCache {

    private[this] val cache = scala.collection.mutable.HashMap.empty[String, BufferedImage]

    def load(fileName: String): Option[BufferedImage] =
        cache.get(fileName) match {
            case Some(n) => Some(n)
            case None    =>
                def loadedImage = Try {
                    ImageIO.read(getClass.getResourceAsStream(fileName))
                }.map {
                    bi =>
                        cache += (fileName -> bi)
                        bi
                }

                loadedImage.toOption
        }

    def cachedImageCount = cache.size

}

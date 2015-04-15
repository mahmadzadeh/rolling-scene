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

    def loadOrThrow(fileName: String): BufferedImage =
        load(fileName).getOrElse(throw new MissingImageException(s"image ${fileName} is missing"))

    def cachedImageCount = cache.size

    def bust: Unit = cache.clear()

}

class MissingImageException(msg:String) extends Exception(msg)

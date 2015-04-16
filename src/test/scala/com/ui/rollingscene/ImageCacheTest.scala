package com.ui.rollingscene

import org.scalatest.FunSuite


class ImageCacheTest extends FunSuite  {
    val imageCache = new ImageCache

    test("given an invalid image then call to load image loads nothing") {
        assertResult(None) {
            imageCache.load("someImage.jpg")
        }
    }

    test("given a valid image then call to load image loads the image ") {
        val file = imageCache.load("/cobra_0.jpg")

        assert(file.isDefined)

        assert(1 === imageCache.cachedImageCount)
    }

    test("given a valid image loading the same image twice will not load it twice ") {
        val file = imageCache.load("/cobra_0.jpg")
        val file2 = imageCache.load("/cobra_0.jpg")

        assert(file.isDefined)

        assert(1 === imageCache.cachedImageCount)
        assert(file.get === file2.get)
    }

    test("given two valid images loading them will increase the cache size") {
        val file = imageCache.load("/cobra_0.jpg")
        val file2 = imageCache.load("/cobra_1.jpg")

        assert(file.isDefined)
        assert(file2.isDefined)

        assert(2 === imageCache.cachedImageCount)
    }

    test("given image cache then call to bust will reset the cache") {
        val file = imageCache.load("/cobra_0.jpg")
        val file2 = imageCache.load("/cobra_1.jpg")

        assert(file.isDefined)
        assert(file2.isDefined)

        assert(2 === imageCache.cachedImageCount)

        imageCache.bust

        assert(0 === imageCache.cachedImageCount)

    }

}

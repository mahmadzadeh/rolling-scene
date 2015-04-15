package com.ui.rollingscene


class ImageCacheTest extends ImageCacheDependantTest {

    test("given an invalid image then call to load image loads nothing") {
        assertResult(None) {
            ImageCache.load("someImage.jpg")
        }
    }

    test("given a valid image then call to load image loads the image ") {
        val file = ImageCache.load("/cobra_0.jpg")

        assert(file.isDefined)

        assert(1 === ImageCache.cachedImageCount)
    }

    test("given a valid image loading the same image twice will not load it twice ") {
        val file = ImageCache.load("/cobra_0.jpg")
        val file2 = ImageCache.load("/cobra_0.jpg")

        assert(file.isDefined)

        assert(1 === ImageCache.cachedImageCount)
        assert(file.get === file2.get)
    }

    test("given two valid images loading them will increase the cache size") {
        val file = ImageCache.load("/cobra_0.jpg")
        val file2 = ImageCache.load("/cobra_1.jpg")

        assert(file.isDefined)
        assert(file2.isDefined)

        assert(2 === ImageCache.cachedImageCount)
    }

    test("given image cache then call to bust will reset the cache") {
        val file = ImageCache.load("/cobra_0.jpg")
        val file2 = ImageCache.load("/cobra_1.jpg")

        assert(file.isDefined)
        assert(file2.isDefined)

        assert(2 === ImageCache.cachedImageCount)

        ImageCache.bust

        assert(0 === ImageCache.cachedImageCount)

    }

}
